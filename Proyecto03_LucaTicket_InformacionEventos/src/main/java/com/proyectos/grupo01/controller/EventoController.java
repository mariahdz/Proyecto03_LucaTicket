package com.proyectos.grupo01.controller;


import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;

/**
 * Controller
 * @author María Hernández
 * @version 07/07/2021/A
 *
 */

@RestController

@RequestMapping("/")

public class EventoController  {

	
	
	private static final Logger log = Logger.getLogger("EventoRepositoryImpl.class");

	
	@Autowired
	EventoRepository eventoRepository;
	
	@GetMapping("/evento/list")
	public Evento[] listarEventos() {
		System.out.println("holaaa");
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
		List <Evento> eventos = eventoRepository.findAll();
		log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
		return eventos.toArray(new Evento[eventos.size()]);
	}
	
	@GetMapping(value="/all")
	public Collection <Evento> listarEventos2() {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
	
		return eventoRepository.findAll();
	}
	
	@GetMapping(value="/list/{id}")
	public Optional<Evento> encontrarPorId (@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR ID");
		Optional<Evento> eventoId = eventoRepository.findById(id);
		return eventoId;
	}
	
	
	@GetMapping("/eventos")
	public ResponseEntity<List<Evento>> getAllEventos(@RequestParam(required = false) Iterable<String> id) {
		try {
			List<Evento> eventos = new ArrayList<Evento>();
			log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
			if (id == null)
				eventoRepository.findAll().forEach(eventos::add);
			else
				eventoRepository.findAllById(id).forEach(eventos::add);

			if (eventos.isEmpty()) {
				log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
				System.out.println("Está vacio");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      
    }
			log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
			return new ResponseEntity<>(eventos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
	


	@PostMapping("/save")
	public ResponseEntity <Evento> addEvento (@RequestBody Evento eventoRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/ADD EVENTO");
		log.infof("Request: ",eventoRequest);
		
		Evento evento = eventoRepository.save(eventoRequest);
		return new ResponseEntity <> (evento, HttpStatus.CREATED);
		
	}
	
	
		

}