package es.urjc.hotelo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HuespedController {
	
	@GetMapping("/login")
	public String login(Model model) {
		return "InicioSesion";
	}

	 
	@GetMapping("/loginerror")
	public String loginerror() {
		return "loginerror"; 
	}
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "Principal";
	}

	
}
