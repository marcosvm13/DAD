package es.urjc.hotelo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.urjc.hotelo.entity.Hotel;
import es.urjc.hotelo.entity.Huesped;
import es.urjc.hotelo.repository.HotelRepository;
import es.urjc.hotelo.repository.HuespedRepository;

@Controller
public class HuespedController {
	
	@Autowired
	private HotelRepository hoteles;
	
	@Autowired
	private HuespedRepository huespedes;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String loginGet(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("error", false);
		return "InicioSesion";
	}
	 
	@GetMapping("/crearHuesped")
	public String crearHotel(Model model) {
		return "crearHuesped";
	}
	
	
	@PostMapping("/signup")
	public String signup(Model model, @RequestParam String nombre, @RequestParam String apellido, @RequestParam String pass, @RequestParam String correo, @RequestParam Long telefono) {
		Huesped u = new Huesped(nombre, apellido , telefono, correo, null, passwordEncoder.encode(pass), "USER");
		huespedes.save(u);
		return "InicioSesion";
	}
	
	@GetMapping("/loginerror")
	public String loginerror(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("error", true);
		return "InicioSesion"; 
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		}
	    model.addAttribute("hoteles", hoteles.findAll());
		return "Principal";
	}

	
}
