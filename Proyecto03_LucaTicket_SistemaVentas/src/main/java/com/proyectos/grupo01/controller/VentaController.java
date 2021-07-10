package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.User;

public class VentaController {
	
	@PostMapping("/venta")
	public boolean verificarVenta (@RequestParam String userName, String eventName) {
	User usuario = restTemplate.postForObject(url, httpEntity, User.class); 
	Evento evento = restTemplate.postForObject(url, httpEntity, Evento.class);
	boolean vendido = restTemplate.postForObject(url, httpEntity, Evento.class);
	}
}
