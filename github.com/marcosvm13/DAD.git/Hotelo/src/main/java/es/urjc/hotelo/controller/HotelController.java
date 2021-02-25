package es.urjc.hotelo.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Reserva;
import es.urjc.hotelo.repository.ActividadHotelRepository;
import es.urjc.hotelo.repository.HotelRepository;

@Controller
public class HotelController {
		
	 @Autowired
	 private HotelRepository hoteles;
	
	 @Autowired 
	 private ActividadHotelRepository actividades ;
	 
	 @Autowired 
	 private ActividadHotelRepository reservas;
	 @PostConstruct
	 public void init() {
			 
		 
		 
		 ActividadHotel ah1 = new ActividadHotel("Actividad Hotel","Descripcion de actividad hotel",10);
		 
		
		 Hotel h1 = new Hotel("Barata, barata", "C/Hola", "Valencia", 1);
		 Hotel h2 = new Hotel("Pago bien", "C/ Ni idea", "Barcelona", 2);
		 Hotel h3 = new Hotel("Tercer hotel", "C/ 9º B", "Cadiz",3);
		 Hotel h4 = new Hotel("Cuarto hotel", "C/ asdasdas", "Madrid", 4);
		 
		

		 ah1.getHoteles().add(h1);
		 h1.getActividades().add(ah1);
		 
		 hoteles.save(h1);
		 hoteles.save(h2);
		 hoteles.save(h3);
		 hoteles.save(h4);
		 
		 actividades.save(ah1);
	 	 
	 }

	@GetMapping("/")
	public String greeting(Model model) {
		model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
	
	
	@GetMapping("/hotel/{id}")
	public String hotel(Model model, Optional<Hotel> hotel, @PathVariable long id) {
		
		hotel = hoteles.findById(id);
		
		
		model.addAttribute("nombreHotel", hotel.get().getNombreHotel());
		model.addAttribute("localidad", hotel.get().getLocalidad());
		model.addAttribute("direccion", hotel.get().getDireccion());
		model.addAttribute("actividades", hotel.get().getActividades());
		System.out.println( hotel.get().getActividades().toString());
		return "hotel";
	}
	

	@GetMapping("/actividad/{id}")
	public String actividad(Model model, Optional<ActividadHotel> actividad, @PathVariable long id) {
		
		actividad = actividades.findById(id);
		
		
		model.addAttribute("nombre", actividad.get().getNombre());
		model.addAttribute("descripcion", actividad.get().getDescripcion());
		model.addAttribute("plazas", actividad.get().getPlazas());
		model.addAttribute("hoteles", actividad.get().getHoteles());
		
		return "actividad";
	}
	
	/*@GetMapping("/reserva/{id}")
	public String reserva(Model model, Optional<Hotel> Hotel, @PathVariable long id) {
			hotel = hoteles.findById(id);
		
		
			model.addAttribute("nombreHotel", hotel.get().getNombreHotel());
			model.addAttribute("localidad", hotel.get().getLocalidad());
			model.addAttribute("direccion", hotel.get().getDireccion());
			model.addAttribute("actividades", hotel.get().getActividades());
			System.out.println( hotel.get().getActividades().toString());
			return "reserva";
		
	}*/

	@GetMapping("/login")
	public String login(Model model) {
		return "InicioSesion";
	}
	
}
