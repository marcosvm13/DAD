package es.urjc.hotelo.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;

import es.urjc.hotelo.repository.HabitacionRepository;
import es.urjc.hotelo.repository.HotelRepository;
import es.urjc.hotelo.servicios.HotelService;
import es.urjc.hotelo.servicios.ImplementacionHotelService;


@Controller
public class HabitacionController {
	
	@Autowired
	private HotelRepository hoteles;
	 	 
	@Autowired
	private HabitacionRepository habitaciones;
	
	@Autowired
	private ImplementacionHotelService service;
	
	@PostMapping("/buscarHabitacion/{id}")
	public String buscarHabitacion(Model model, Optional<Hotel> Hotel, 
			@PathVariable long id, @RequestParam String fechaI, @RequestParam String fechaF, HttpServletRequest request) {		
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate dateI = null;
		LocalDate dateF = null;
		dateI = LocalDate.parse(fechaI, format);
		dateF = LocalDate.parse(fechaF, format);
		HashMap<String, Habitacion> tipos = new HashMap<>();
			
		for(Habitacion h: hoteles.findById(id).get().getHabitaciones()) {
			HashSet<LocalDate> ocupacion= h.getOcupacion();
			boolean esta = false;
			for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
				if(ocupacion.contains(d)) {
					esta = true;
				}
			}
			if(!esta) {
				tipos.put(h.getTamayo(), h);
			}
		}
					
		if(!tipos.isEmpty()) {
				
			model.addAttribute("fechaI", fechaI);
			model.addAttribute("fechaF", fechaF);
			model.addAttribute("primero", false);
			model.addAttribute("habitacion", tipos.values());
			return "Reserva";
		}
		return "Reserva";
	}	   
	
	
	@PostMapping(value="/nuevaHabitacion/{id}", params="terminar")
	public String nuevaHabitacionTerminar(Model model, @PathVariable Long id,  @RequestParam String numero, @RequestParam String tamayo, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Hotel hotel = hoteles.findById(id).get();
		Habitacion h = new Habitacion(Integer.parseInt(numero), hotel, tamayo);
		hotel.getHabitaciones().add(h);
		habitaciones.save(h);
		model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
	
	
	@PostMapping(value="/nuevaHabitacion/{id}", params="otra")
	public String nuevaHabitacionSeguir(Model model, @PathVariable Long id,  @RequestParam String numero, @RequestParam String tamayo, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Hotel hotel = hoteles.findById(id).get();
		Habitacion h = new Habitacion(Integer.parseInt(numero), hotel, tamayo);
		hotel.getHabitaciones().add(h);
		habitaciones.save(h);
		service.updateHotel(hotel);
		model.addAttribute("nombreHotel", hotel.getNombreHotel());
		model.addAttribute("id", hotel.getId());
		return "AyadirHabitaciones";
	}
	
	
	@GetMapping("/nuevaHabitacion2/{id}")
	public String nuevaHabitacion2(Model model, @PathVariable Long id, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Hotel h = hoteles.findById(id).get();
		
		model.addAttribute("nombreHotel", h.getNombreHotel());
		model.addAttribute("id", h.getId());
		return "AyadirHabitaciones";
	}
	
	
	@GetMapping("/eliminarHabitacion/{id}")
	public String eliminarActividad(Model model, @PathVariable Long id, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Habitacion a = habitaciones.findById(id).get();		
		Hotel h = a.getHotel();
		service.updateHotel(h);
		habitaciones.deleteById(id);
		model.addAttribute("hotel", h);
		return "Hotel";
	}
	
}
