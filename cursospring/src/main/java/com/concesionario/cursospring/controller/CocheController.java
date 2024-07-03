package com.concesionario.cursospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import com.concesionario.cursospring.entity.Coche;
import com.concesionario.cursospring.service.CocheService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CocheController {
	
	@Autowired
	private CocheService cocheService;

	@GetMapping("/coches/all-coches")
	public String getMethodName(ModelMap c) {
		List<Coche> coches = cocheService.listAll();
        c.put("view", "coches/all-coches");
		return "_t/frame";
	}
	


}
