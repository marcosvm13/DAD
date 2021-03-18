package es.urjc.hotelo.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.hotelo.entity.ActividadHotel;
import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.repository.ActividadHotelRepository;

import es.urjc.hotelo.repository.HotelRepository;



@Controller
public class ActividadController {
	
	@Autowired
	private HotelRepository hoteles;
	
	@Autowired 
	private ActividadHotelRepository actividades ;
	 
	@RequestMapping("/principalActividades")
	public String principalActividades(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("actividades", actividades.findAll());
		return "Principal2";
	}
	
	
	@GetMapping("/actividad/{id}")
	public String actividad(Model model, Optional<ActividadHotel> actividad, @PathVariable long id, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		actividad = actividades.findById(id);
		model.addAttribute("actividad", actividad.get());
		return "actividad";
	}
	
	
	@GetMapping("/crearActividad")
	public String crearActividad(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("hoteles", hoteles.findAll());
		return "InsertarActividad";
	}
	
	
	@PostMapping("/actividadCreada")
	public String creadoActividad(Model model, @RequestParam String nombre, @RequestParam String aforo, @RequestParam String descripcion, @RequestParam(required = false) String[] hotelesActividad, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		if(hotelesActividad == null) {
			model.addAttribute("actividades", actividades.findAll());
			
			return "InsertarHotel";
		}
		
		ActividadHotel a = new ActividadHotel(nombre, descripcion, Integer.parseInt(aforo));
		
		for(String h: hotelesActividad) {
			
			Hotel h1 = hoteles.findByNombreHotel(h);
		
			a.getHoteles().add(h1);
			h1.getActividades().add(a);
			
		}
		actividades.save(a);
		
		model.addAttribute("actividades", actividades.findAll());
		return "Principal2";
	}
	
	
	@GetMapping("/nuevaActividad/{id}")
	public String nuevaActividad(Model model, @PathVariable Long id, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Hotel h = hoteles.findById(id).get();
		model.addAttribute("nombreHotel", h.getNombreHotel());
		model.addAttribute("id", h.getId());
		List<ActividadHotel> actividadLista = new LinkedList<>();
		for(ActividadHotel act: actividades.findAll()) {
			if(!h.getActividades().contains(act)) {
				actividadLista.add(act);
			}
		}
		model.addAttribute("actividades", actividadLista);
		return "AyadirActividad";
	}
	
	
	@PostMapping("/actividadAyadida/{id}")
	public String actividadAyadida(Model model, @PathVariable Long id,  @RequestParam(required = false) String[] actividadesHotel, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		Hotel h = hoteles.findById(id).get();
		if(actividadesHotel != null) {
			for(String a: actividadesHotel) {
				ActividadHotel act1= actividades.findByNombre(a);
				h.getActividades().add(act1);
				act1.getHoteles().add(h);
				actividades.save(act1);
			}
			hoteles.save(h);
		}
		model.addAttribute("hotel", h);
		return "hotel";
	}
	
	
	@GetMapping("/eliminarActividad/{id}")
	public String eliminarActividad(Model model, @PathVariable Long id, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		ActividadHotel a = actividades.findById(id).get();
		for(Hotel h: a.getHoteles()) {
			h.getActividades().remove(a);
			hoteles.save(h);
		}
		a.getHoteles().clear();
		actividades.save(a);
		
		actividades.deleteById(id);
		model.addAttribute("actividades", actividades.findAll());
		return "Principal2";
	}
	
}
