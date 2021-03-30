package es.urjc.hotelo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import es.urjc.hotelo.repository.HotelRepository;

@Controller
public class HuespedController {
	
	@Autowired
	private HotelRepository hoteles;
	
	@GetMapping("/login")
	public String loginGet(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		model.addAttribute("error", false);
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
