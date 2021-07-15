package com.proyectos.grupo01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.model.Evento;

import java.io.IOException;

import org.jboss.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.client.RestTemplate;

import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.model.Venta;

@RestController
public class VentaController {
	
	
	@Autowired
	RestTemplate restTemplate;
	
	private static final Logger log = Logger.getLogger("VentaRepositoryImpl.class");
	
	
	@GetMapping("/venta/{id}/{idUsuario}")
	public ResponseEntity<Boolean> comprobarVenta (@PathVariable String id, @PathVariable int idUsuario) throws IOException {

	log.info("---Se ha invocado el método comprobarVenta");

	String url = "http://localhost:4444/evento/" + id;
	String url2 = "http://localhost:3333/usuario/" + idUsuario;

	ResponseEntity<Evento> response= restTemplate.getForEntity(url, Evento.class);
	ResponseEntity<Usuario> response2= restTemplate.getForEntity(url2, Usuario.class);

		if(response.getStatusCode().equals(HttpStatus.OK) && response2.getStatusCode().equals(HttpStatus.OK)) {
			String uri = "http://localhost:6666/pasarela";
			return restTemplate.getForEntity(uri, Boolean.class);
		}
	return null;
	}
	
}


