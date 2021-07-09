package com.proyectos.grupo01.controller;

public class VentaController {
	
	PostMapping("/venta")
	public boolean verificarVenta (RequestParam String userName, String eventName) {
	User usuario = restTemplate.postForObject(url, httpEntity, User.class); 
	Evento evento = restTemplate.postForObject(url, httpEntity, Evento.class);
	boolean vendido = restTemplate.postForObject(url, httpEntity, Evento.class);
	}
}
