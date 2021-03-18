package es.urjc.hotelo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HuespedController {
	
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
	public String logout(Model model, HttpServletRequest request) {
		model.addAttribute("user", request.isUserInRole("USER"));
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "Principal";
	}

	
}
