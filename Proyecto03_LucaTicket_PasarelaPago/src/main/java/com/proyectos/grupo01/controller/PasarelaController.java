package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasarelaController {

	@GetMapping("/pasarela")
	public boolean pasarelaPago () {
		
		boolean venta = Math.random() < 0.5;

		return venta;
	}

}
