package com.proyectos.grupo01.controller;

import java.util.ArrayList;
import java.util.Collection;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.error.EventoNotFoundException;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;
import com.proyectos.grupo01.services.EventoService;
import com.proyectos.grupo01.services.EventoServiceImpl;

/**
 * Controller
 * 
 * @author María Hernández
 * @version 07/07/2021/A
 *
 */

@RestController

@RequestMapping("/")

public class EventoController {

	private static final Logger log = Logger.getLogger("EventoRepositoryImpl.class");

	@Autowired
	EventoService service;

	/**
	 * Metodo para listar todos los eventos de la coleccion
	 * 
	 * @param
	 * @return Evento[]
	 * @author
	 */
	@GetMapping("/evento/list")
	public Evento[] listarEventos() {
		System.out.println("holaaa");
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
		List<Evento> eventos = service.findAll();
		log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size()
				+ " valores");
		return eventos.toArray(new Evento[eventos.size()]);
	}

	/**
	 * Metodo para listar todos los eventos de la coleccion
	 * 
	 * @param
	 * @return Collection <Evento>
	 * @author
	 */
	@GetMapping(value = "/all")
	public Collection<Evento> listarEventos2() {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");

		return service.findAll();
	}

	/*
	 * //Encontrar evento por ID
	 * 
	 * @GetMapping(value="/{id}") public Optional<Evento> encontrarPorId
	 * (@PathVariable("id") String id) { log.
	 * info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR ID"
	 * ); Optional<Evento> eventoId = service.findById(id); return eventoId; }
	 */

	/**
	 * Metodo para listar un evento por su ID
	 * 
	 * @param String
	 * @return Evento
	 * @author
	 */
	//Daniela-he añadido excepcion al return
	@GetMapping(value = "/{id}")
	public Evento encontrarPorId(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR ID");
		Optional<Evento> eventoId = service.findById(id);
		return eventoId.orElseThrow(() -> new EventoNotFoundException(id));
	}
	
	//probando codigos de estado
	@GetMapping("evento/daniela/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable String id){
		Evento result = service.findById(id).orElse(null);
		if(result == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(result);
		}
	}

	/**
	 * Metodo para listar eventos por su descripcion corta
	 * 
	 * @param String
	 * @return ResponseEntity
	 * @author
	 */
	@GetMapping(value = "/list/{descripcionCorta}")
	public ResponseEntity<List<Evento>> encontrarPorGenero(@PathVariable("descripcionCorta") String descripcionCorta) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR GÉNERO MÚSICA");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos = service.findByGenero(descripcionCorta);
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	/**
	 * Metodo para listar eventos por su nombre
	 * 
	 * @param String
	 * @return Evento[]
	 * @author
	 */
	@GetMapping(value = "evento/list/{nombre}")
	public ResponseEntity<List<Evento>> encontrarPorNombre(@PathVariable("nombre") String nombre) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR NOMBRE");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos = service.findByName(nombre);
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	/**
	 * Metodo para listar todos los eventos de la coleccion
	 * 
	 * @param
	 * @return ResponseEntity
	 * @author
	 */
	@GetMapping("/eventos")
	public ResponseEntity<List<Evento>> getAllEventos(@RequestParam(required = false) Iterable<String> id) {
		try {
			List<Evento> eventos = new ArrayList<Evento>();
			log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
			if (id == null)
				service.findAll().forEach(eventos::add);
			else
				service.findAllById(id).forEach(eventos::add);

			if (eventos.isEmpty()) {
				log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size()
						+ " valores");
				System.out.println("Está vacio");
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}
			log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size()
					+ " valores");
			return new ResponseEntity<>(eventos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/save")
	public ResponseEntity<Evento> addEvento(@RequestBody Evento eventoRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/ADD EVENTO");
		// log.infof("Request: ",eventoRequest);

		Evento evento = service.save(eventoRequest);
		return new ResponseEntity<>(evento, HttpStatus.CREATED);

	}

}