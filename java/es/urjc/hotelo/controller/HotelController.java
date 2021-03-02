package es.urjc.hotelo.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Habitacion;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.entity.Reserva;
import es.urjc.hotelo.entity.ServicioHabitacion;
import es.urjc.hotelo.repository.ActividadHotelRepository;
import es.urjc.hotelo.repository.HabitacionRepository;
import es.urjc.hotelo.repository.HotelRepository;
import es.urjc.hotelo.repository.HuespedRepository;
import es.urjc.hotelo.repository.ReservaRepository;

@Controller
public class HotelController {
		
	 @Autowired
	 private HotelRepository hoteles;
	 
	 @Autowired
	 private HuespedRepository huespedes;
	
	 @Autowired 
	 private ActividadHotelRepository actividades ;
	 
	 @Autowired 
	 private ReservaRepository reservas;
	 
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

	@RequestMapping("/")
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
		//System.out.println( hotel.get().getActividades().toString());
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
	
	@GetMapping("/reserva/{id}")
	public String reserva(Model model, Optional<Hotel> Hotel, @PathVariable long id) {		
			model.addAttribute("id", id);
			model.addAttribute("primero", true);
			return "reserva";
		
	}
	
	@PostMapping("/buscarHabitacion/{id}")
	public String buscarHabitacion(Model model, Optional<Hotel> Hotel, 
			@PathVariable long id, @RequestParam String fechaI, @RequestParam String fechaF) {		
			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate dateI = null;
			LocalDate dateF = null;
			dateI = LocalDate.parse(fechaI, format);
			dateF = LocalDate.parse(fechaF, format);
	
			
			//Poner Funciones y hacerlo con whiles Y PONER UNA NUEVA RESERVA
			
			
			for(Habitacion h: hoteles.findById(id).get().getHabitaciones()) {
				HashSet<LocalDate> ocupacion= h.getOcupacion();
				boolean esta = false;
				for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
					if(ocupacion.contains(d)) {
						esta = true;
					}
				}
				if(!esta) {
					model.addAttribute("fechaI", fechaI);
					model.addAttribute("fechaF", fechaF);
					model.addAttribute("primero", false);
					model.addAttribute("habitacion", h);
					return "reserva";
				}
			}
			model.addAttribute("hoteles", hoteles.findAll());
			return "Principal";
	}	   
	
	@GetMapping("/reservaCompleta/{id}/{fechaI}/{fechaF}")
	public String reservaCompleta(Model model, Optional<Habitacion> habitacion, @PathVariable long id, @PathVariable String fechaI, @PathVariable String fechaF) {		
		System.out.println("SE EJECUTA");
		habitacion= habitaciones.findById(id);
		HashSet<LocalDate> ocupacion= habitacion.get().getOcupacion();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dateI = null;
		LocalDate dateF = null;
		dateI = LocalDate.parse(fechaI, format);
		dateF = LocalDate.parse(fechaF, format);
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
			if(ocupacion.contains(d)) {
				model.addAttribute("hoteles", hoteles.findAll());
				return "Principal";
			}
			}
		for(LocalDate d: dateI.datesUntil(dateF).collect(Collectors.toList())) {
				ocupacion.add(d);
		}
				Optional<Huesped> usu = huespedes.findById((long) 1);
						
				Reserva reserva = new Reserva(usu.get(), habitacion.get(), fechaI, fechaF);
				
				reservas.save(reserva);
				model.addAttribute("reserva",reserva);
				return "ConfirmarReserva";
	}
	
	@GetMapping("/crearHotel")
	public String crearHotel(Model model) {
		model.addAttribute("actividades", actividades.findAll());
		return "InsertarHotel";
	}
	
	@GetMapping("/crearActividad")
	public String crearActividad(Model model) {
		model.addAttribute("hoteles", hoteles.findAll());
		return "InsertarActividad";
	}
	
	@PostMapping("/hotelCreado")
	public String creadoHotel(Model model, @RequestParam String nombre, @RequestParam String localidad, @RequestParam String direccion, @RequestParam String estrellas,  @RequestParam String[] actividadesHotel) {
		Hotel h = new Hotel(nombre, localidad, direccion, Float.parseFloat(estrellas));
		
		for(String a: actividadesHotel) {
			h.getActividades().addAll(actividades.findByNombre(nombre));
		}
		hoteles.save(h);
		model.addAttribute("nombreHotel", h.getNombreHotel());
		model.addAttribute("id", h.getId());
		return "AyadirHabitaciones";
	}
	
	@PostMapping("/actividadCreada")
	public String creadoActividad(Model model, @RequestParam String nombre, @RequestParam String aforo, @RequestParam String descripcion, @RequestParam String[] hotelesActividad) {
		ActividadHotel a = new ActividadHotel(nombre, descripcion, Integer.parseInt(aforo));
		
		for(String h: hotelesActividad) {
			a.getHoteles().add(hoteles.findByNombreHotel(nombre));
		}
		actividades.save(a);
		model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
	
	@GetMapping("/misReservas")
	public String misReservas(Model model) {
		
		Optional<Huesped> usu = huespedes.findById((long) 1);
		
		model.addAttribute("huesped", usu.get());
		model.addAttribute("reservas",usu.get().getReservas());
		
		return "MisReservas";
	}
	
	@GetMapping("/nuevaHabitacion2/{id}")
	public String nuevaHabitacion2(Model model, @PathVariable Long id) {
		Hotel h = hoteles.findById(id).get();
		model.addAttribute("nombreHotel", h.getNombreHotel());
		model.addAttribute("id", h.getId());
		return "AyadirHabitaciones";
	}
	
	@PostMapping(value="/nuevaHabitacion/{id}", params="terminar")
	public String nuevaHabitacionTerminar(Model model, @PathVariable Long id,  @RequestParam String numero, @RequestParam String tamayo) {
		
		Habitacion h = new Habitacion(Integer.parseInt(numero), hoteles.findById(id).get(), tamayo);
		 habitaciones.save(h);
		 model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}
	
	@PostMapping(value="/nuevaHabitacion/{id}", params="otra")
	public String nuevaHabitacionSeguir(Model model, @PathVariable Long id,  @RequestParam String numero, @RequestParam String tamayo) {
		Hotel hotel = hoteles.findById(id).get();
		Habitacion h = new Habitacion(Integer.parseInt(numero), hotel, tamayo);
		habitaciones.save(h);
		model.addAttribute("nombreHotel", hotel.getNombreHotel());
		model.addAttribute("id", hotel.getId());
		return "AyadirHabitaciones";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		return "InicioSesion";
	}
	
}
