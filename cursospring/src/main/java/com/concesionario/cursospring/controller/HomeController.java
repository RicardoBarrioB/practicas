package com.concesionario.cursospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(ModelMap m) {
		m.put("view", "home/homeview");
		return "_t/frame";
	}
}
