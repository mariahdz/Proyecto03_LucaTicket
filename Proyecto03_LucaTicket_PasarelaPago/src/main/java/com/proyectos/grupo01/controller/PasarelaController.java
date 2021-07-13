package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasarelaController {
	
	@PostMapping("/pasarela")
	public boolean pasarelaPago (String nombreEvento, int id) {
		
		boolean venta = Math.random() < 0.5;	
		return venta;
	}

}
