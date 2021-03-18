package es.urjc.hotelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HuespedController {
	
	@GetMapping("/login")
	public String loginGet(Model model) {
		model.addAttribute("error", false);
		return "InicioSesion";
	}
	 
	@GetMapping("/loginerror")
	public String loginerror(Model model) {
		model.addAttribute("error", true);
		return "InicioSesion"; 
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "Principal";
	}

	
}
