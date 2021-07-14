package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.model.Evento;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;


import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.model.Venta;

@RestController
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
	public boolean comprobarVenta (@RequestParam String nombreEvento, @RequestParam int id) {
	
		ResponseEntity<Evento> responseEntityEvento= new RestTemplate().getForEntity("https://localhost:2222/evento/¨{nombre}", Evento.class);
		ResponseEntity<Usuario> responseEntityUsuario= new RestTemplate().getForEntity("https://localhost:3333/usuario/{id}", Usuario.class);
		
		RestTemplate restTemplate = new RestTemplate();
		
		if(responseEntityEvento.getStatusCode() == HttpStatus.OK && responseEntityUsuario.getStatusCode() == HttpStatus.OK) {
			
			Venta venta = new Venta();
			venta.setEvento(responseEntityEvento.getBody());
			venta.setUser(responseEntityUsuario.getBody());
			restTemplate.postForObject("https://localhost:6666/pasarela", venta, Venta.class);
			return true;
		}
		return false;
		
	}
	
	@PostMapping("/venta/prueba")
	public boolean comprobarVenta2 (@RequestParam String nombreEvento, @RequestParam int id) {
		String url2 = "https://localhost:4444/eventos/list/¨{nombre:Dream Beach}";
		String url1 = "https://localhost:3333/usuario/{id: 1}";
		String notification2 = "{\"nombre\"}";
		String notification = "{\"id\"}";
		
		ResponseEntity<Evento> responseEntityEvento= new RestTemplate().getForEntity(url1, null,  Usuario.class, notification);
		ResponseEntity<Usuario> responseEntityUsuario= new RestTemplate().getForEntity( url2, null, Evento.class, notification2);
		
		RestTemplate restTemplate = new RestTemplate();
		
		if(responseEntityEvento.getStatusCode() == HttpStatus.OK && responseEntityUsuario.getStatusCode() == HttpStatus.OK) {
			
			Venta venta = new Venta();
			venta.setEvento(responseEntityEvento.getBody());
			venta.setUser(responseEntityUsuario.getBody());
			restTemplate.postForObject("https://localhost:6666/pasarela", venta, Venta.class);
			return true;
		}
		return false;
		
	}
}

