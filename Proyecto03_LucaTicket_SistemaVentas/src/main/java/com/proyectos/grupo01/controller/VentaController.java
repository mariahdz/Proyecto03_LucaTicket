package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyectos.grupo01.model.Evento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.model.Venta;

public class VentaController {
	
	/*PostMapping("/venta")
	public boolean verificarVenta (RequestParam String userName, String eventName) {
	User usuario = restTemplate.postForObject(url, httpEntity, User.class); 
	Evento evento = restTemplate.postForObject(url, httpEntity, Evento.class);
	boolean vendido = restTemplate.postForObject(url, httpEntity, Evento.class);
	}*/
	
	@PostMapping("/new/venta")
	public Venta crearVenta (RequestParam String, String nombreEvento, String id) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Usuario usuario = restTemplate.getForObject("https://localhost:3333/usuario/{id}", Usuario.class); 
		Evento evento = restTemplate.getForObject("https://localhost:2222/evento/¨{nombre}", Evento.class);
		Venta venta = new Venta();
		venta.setEvento(evento);
		venta.setUser(usuario);
		return venta;
		}
	
	@PostMapping("/venta")
	public boolean comprobarVenta (RequestParam String, String nombreEvento, String id) {
	
		ResponseEntity<Evento> responseEntityEvento= new RestTemplate().getForEntity("https://localhost:2222/evento/¨{nombre}", Evento.class);
		ResponseEntity<Usuario> responseEntityUsuario= new RestTemplate().getForEntity("https://localhost:3333/usuario/{id}", Usuario.class);
		
		if(responseEntityEvento.getStatusCode() == HttpStatus.OK && responseEntityUsuario.getStatusCode() == HttpStatus.OK) {
			responseEntityEvento.getBody();
			responseEntityUsuario.getBody();
			return true;
		}
		return false;
		
	}
}

