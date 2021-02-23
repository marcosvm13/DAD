package es.urjc.hotelo.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.repository.HotelRepository;

@Controller
public class HotelController {
		
	 @Autowired
	 private HotelRepository hoteles;
	
	 @PostConstruct
	 public void init() {
		 hoteles.save(new Hotel("Barata, barata", "C/Hola", null, null, 1));
		 hoteles.save(new Hotel( "Pago bien", "C/ Ni idea", null, null, 2 ));
		 hoteles.save(new Hotel( "Tercer hotel", "C/ 9º B", null, null, 3));
		 hoteles.save(new Hotel( "Cuarto hotel", "C/ asdasdas", null, null, 4 ));
	 }

	@GetMapping("/")
	public String greeting(Model model) {
		model.addAttribute("hoteles", hoteles.findAll());
		//model.addAttribute("name", "HOLA");
		return "Principal";
	}
	
	/*@GetMapping("/basic")
	public String basic(Model model) {
		 model.addAttribute("name","World");
		 return "prueba";
	}*/
	
	/*@GetMapping("/hotel")
	public String hotel(@RequestParam long id) {
		
		hoteles.findById(id);
		
		return "hotel.html";
	}
	
	@GetMapping("/actividad")
	public String actividad() {
		
		return "actividad.html";
	}*/
}
