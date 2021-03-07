package es.urjc.hotelo.controller;


import java.util.Optional;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Huesped;

import es.urjc.hotelo.repository.ActividadHotelRepository;
import es.urjc.hotelo.repository.HabitacionRepository;
import es.urjc.hotelo.repository.HotelRepository;
import es.urjc.hotelo.repository.HuespedRepository;


@Controller
public class HotelController {
	
	@Autowired
	private HotelRepository hoteles;
	 
	@Autowired
	private HuespedRepository huespedes;
	
	@Autowired 
	private ActividadHotelRepository actividades ;
	 
	@Autowired
	private HabitacionRepository habitaciones;
	 
	@PostConstruct
	public void init() {
		
		ActividadHotel ah1 = new ActividadHotel("Actividad Hotel","Descripcion de actividad hotel",10);
		 
		Hotel h1 = new Hotel("Barata, barata", "C/Hola", "Valencia", 1);
		Hotel h2 = new Hotel("Pago bien", "C/ Ni idea", "Barcelona", 2);
		Hotel h3 = new Hotel("Tercer hotel", "C/ 9º B", "Cadiz",3);
		Hotel h4 = new Hotel("Cuarto hotel", "C/ asdasdas", "Madrid", 4);
		 
		Huesped usuario1 = new Huesped("Huesped 1", "Apellido1" , 111111111, "huesped1@gmail.com");
		huespedes.save(usuario1);
		 
		ah1.getHoteles().add(h1);
		h1.getActividades().add(ah1);
		 
		hoteles.save(h1);
		hoteles.save(h2);
		hoteles.save(h3);
		hoteles.save(h4);
		 
		actividades.save(ah1);
	 	 
		Habitacion ha1 = new Habitacion(34, h1, "40x40" );
		Habitacion ha2 = new Habitacion(35, h1, "300x300" );
		Habitacion ha3 = new Habitacion(02, h2, "20x20");
		 
		habitaciones.save(ha1);
		habitaciones.save(ha2);
		habitaciones.save(ha3);
	}

	 
	@RequestMapping(value={"/", "principalHoteles"})
	public String greeting(Model model) {
		model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
		
	
	@GetMapping("/hotel/{id}")
	public String hotel(Model model, Optional<Hotel> hotel, @PathVariable long id) {
		hotel = hoteles.findById(id);
		model.addAttribute("hotel", hotel.get());
		return "hotel";
	}
	
	
	@GetMapping("/crearHotel")
	public String crearHotel(Model model) {
		model.addAttribute("actividades", actividades.findAll());
		return "InsertarHotel";
	}
	

	@PostMapping("/hotelCreado")
	public String creadoHotel(Model model, @RequestParam String nombre, @RequestParam String localidad, @RequestParam String direccion, @RequestParam String estrellas,  @RequestParam(required = false) String[] actividadesHotel) {
		
		Hotel h = new Hotel(nombre, localidad, direccion, Integer.parseInt(estrellas));
		if(actividadesHotel != null) {
			for(String a: actividadesHotel) {
				ActividadHotel act1= actividades.findByNombre(a);
				h.getActividades().add(act1);
				act1.getHoteles().add(h);
				
			}
		}
		hoteles.save(h);
		model.addAttribute("nombreHotel", h.getNombreHotel());
		model.addAttribute("id", h.getId());
		return "AyadirHabitaciones";
	}
	
	
	@GetMapping("/eliminarHotel/{id}")
	public String eliminarHotel(Model model, @PathVariable Long id) {
		Hotel h = hoteles.findById(id).get();
		for(ActividadHotel a: h.getActividades()) {
			a.getHoteles().remove(h);
			
		}
		h.getActividades().clear();
		hoteles.save(h);
		
		hoteles.deleteById(id);
		model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
	
	
	@GetMapping("/login")
	public String login(Model model) {
		return "InicioSesion";
	}
	
}