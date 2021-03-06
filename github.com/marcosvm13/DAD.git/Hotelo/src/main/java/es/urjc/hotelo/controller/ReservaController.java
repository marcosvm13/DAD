package es.urjc.hotelo.controller;

import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import es.urjc.hotelo.entity.Correo;
import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;

import es.urjc.hotelo.repository.HabitacionRepository;

import es.urjc.hotelo.repository.HuespedRepository;
import es.urjc.hotelo.repository.ReservaRepository;

@Controller
public class ReservaController {

	
	
	 
	 @Autowired
	 private HuespedRepository huespedes;
	
	 
	 @Autowired 
	 private ReservaRepository reservas;
	 
	 @Autowired
	 private HabitacionRepository habitaciones;
	 

	@GetMapping("/reserva/{id}")
	public String reserva(Model model, HttpServletRequest request, Optional<Hotel> Hotel, @PathVariable long id) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("id", id);
		model.addAttribute("primero", true);
		return "Reserva";
	}
		
	
	@GetMapping("/reservaCompleta/{id}/{fechaI}/{fechaF}")
	public String reservaCompleta(Model model, HttpServletRequest request, Optional<Habitacion> habitacion, @PathVariable long id, @PathVariable String fechaI, @PathVariable String fechaF) {		
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		habitacion= habitaciones.findById(id);
		HashSet<LocalDate> ocupacion= habitacion.get().getOcupacion();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateI = null;
		LocalDate dateF = null;
		dateI = LocalDate.parse(fechaI, format);
		dateF = LocalDate.parse(fechaF, format);
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			if(ocupacion.contains(d)) {
				model.addAttribute("mal", true);
				return "ConfirmarReserva";
			}
		}
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			ocupacion.add(d);
		}
					
		Optional<Huesped> usu = huespedes.findByNombreHuesped(request.getUserPrincipal().getName());	
			
		Reserva reserva = new Reserva(usu.get(), habitacion.get(), fechaI, fechaF);
		 
		reservas.save(reserva);
		// REST
		
		
		RestTemplate restTemplate = new RestTemplate();
		
		
		
		String url="http://haproxyR:8090/email/send";
		
		HttpEntity<Correo> re = new HttpEntity<>(new Correo(usu.get().getCorreo(), "Buenos dias " + usu.get().getNombreHuesped() + ".\n Reserva realizada para los dias " + reserva.getFechaDeEntrada() + " a " + reserva.getFechaDeSalida()+ " en la habitacion " + reserva.getHabitacion().getNumero() + " de tamayo " + reserva.getHabitacion().getTamayo() + ", del hotel " + reserva.getHabitacion().getHotel().getNombreHotel() + ", en la direccion "+ reserva.getHabitacion().getHotel().getDireccion()+ " con numero de referencia "+ reserva.getId() +".\n Esperemos que disfrute, \n Un saludo.","Reserva Hotelo"));	
		
		try{
			
	        restTemplate.postForEntity(url, re, String.class);
	    
		}catch(HttpStatusCodeException e){}
		
		//
		
		
	
		model.addAttribute("reserva",reserva);
		return "ConfirmarReserva";
	}
		
	
	@GetMapping("/misReservas")
	public String misReservas(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));	
		Optional<Huesped> usu = huespedes.findByNombreHuesped(request.getUserPrincipal().getName());	
		model.addAttribute("huesped", usu.get());
		model.addAttribute("reservas",usu.get().getReservas());
		return "MisReservas";
	}
		
	
	@GetMapping("/eliminarReserva/{id}")
	public String eliminarReserva(Model model, HttpServletRequest request, @PathVariable Long id) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Reserva r = reservas.findById(id).get();
		Habitacion h = r.getHabitacion();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateI = LocalDate.parse(r.getFechaDeEntrada(), format);
		LocalDate dateF = LocalDate.parse(r.getFechaDeSalida(), format);	
		
		
		Optional<Huesped> usu = huespedes.findByNombreHuesped(request.getUserPrincipal().getName());	
		
		// REST
		
		
		RestTemplate restTemplate = new RestTemplate();

		String url="http://haproxyR:8090/email/send";
		
		HttpEntity<Correo> re = new HttpEntity<>(new Correo(usu.get().getCorreo(), "Buenos dias " + usu.get().getNombreHuesped() + ".\n Se ha cancelado su reserva para los dias " + r.getFechaDeEntrada() + " a " + r.getFechaDeSalida()+ " con numero de referencia " + r.getId() +".\n", "Cancelación de Reserva"));
		
		try{
			
	        restTemplate.postForEntity(url, re, String.class);
	    
		}catch(HttpStatusCodeException e){}
		
		
		
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			h.getOcupacion().remove(d);
		}
		h.getReservas().remove(r);
		habitaciones.save(h);
		
		model.addAttribute("huesped", usu.get());
		model.addAttribute("reservas",usu.get().getReservas());
		return "MisReservas";
	}
	
	
}
