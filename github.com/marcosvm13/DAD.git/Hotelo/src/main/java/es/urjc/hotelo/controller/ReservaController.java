package es.urjc.hotelo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;

import es.urjc.hotelo.repository.HabitacionRepository;

import es.urjc.hotelo.repository.HuespedRepository;
import es.urjc.hotelo.repository.ReservaRepository;

@Controller
public class ReservaController {

	
	private DateTimeFormatter format2 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	 
	 @Autowired
	 private HuespedRepository huespedes;
	
	 
	 @Autowired 
	 private ReservaRepository reservas;
	 
	 @Autowired
	 private HabitacionRepository habitaciones;
	 

	@GetMapping("/reserva/{id}")
	public String reserva(Model model, Optional<Hotel> Hotel, @PathVariable long id) {		
		model.addAttribute("id", id);
		model.addAttribute("primero", true);
		return "reserva";
	}
		
	
	@GetMapping("/reservaCompleta/{id}/{fechaI}/{fechaF}")
	public String reservaCompleta(Model model, Optional<Habitacion> habitacion, @PathVariable long id, @PathVariable String fechaI, @PathVariable String fechaF) {		
		habitacion= habitaciones.findById(id);
		HashSet<String> ocupacion= habitacion.get().getOcupacion();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateI = null;
		LocalDate dateF = null;
		dateI = LocalDate.parse(fechaI, format);
		dateF = LocalDate.parse(fechaF, format);
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			if(ocupacion.contains(d.format(format2))) {
				model.addAttribute("mal", true);
				return "ConfirmarReserva";
			}
		}
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			
			String text = d.format(format2);
			ocupacion.add(text);
		}
					
		Optional<Huesped> usu = huespedes.findById((long) 1);
							
		Reserva reserva = new Reserva(usu.get(), habitacion.get(), fechaI, fechaF);
		System.out.println(reserva);			
		reservas.save(reserva);
		model.addAttribute("reserva",reserva);
		return "ConfirmarReserva";
	}
		
	
	@GetMapping("/misReservas")
	public String misReservas(Model model) {
			
		Optional<Huesped> usu = huespedes.findById((long) 1);
			
		model.addAttribute("huesped", usu.get());
		model.addAttribute("reservas",usu.get().getReservas());
			
		return "MisReservas";
	}
		
	
	@GetMapping("/eliminarReserva/{id}")
	public String eliminarReserva(Model model, @PathVariable Long id) {
			
		Reserva r = reservas.findById(id).get();
		Habitacion h = r.getHabitacion();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateI = LocalDate.parse(r.getFechaDeEntrada(), format);
		LocalDate dateF = LocalDate.parse(r.getFechaDeSalida(), format);	
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
		
			h.getOcupacion().remove(d.format(format2));
		}
		h.getReservas().remove(r);
		habitaciones.save(h);
			
		Optional<Huesped> usu = huespedes.findById((long) 1);
			
		model.addAttribute("huesped", usu.get());
		model.addAttribute("reservas",usu.get().getReservas());
			
		return "MisReservas";
	}
}
