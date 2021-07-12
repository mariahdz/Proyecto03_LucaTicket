package com.proyectos.grupo01.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.proyectos.grupo01.error.EventoNotFoundException;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.services.EventoService;





/**
 * Controller
 * 
 * @author María Hernández
 * @version 07/07/2021/A
 *
 */

@RestController

@RequestMapping("/")
public class EventoController  {


	private static final Logger log = Logger.getLogger("EventoRepositoryImpl.class");

	@Autowired
	EventoService service;



	/**
	 * Metodo para listar un evento por su ID
	 * 
	 * @param String
	 * @return Evento
	 * @author
	 */
	@GetMapping(value = "/{id}")
	public Evento encontrarPorId(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTAR POR ID");
		Optional<Evento> eventoId = service.findById(id);
		return eventoId.orElseThrow(() -> new EventoNotFoundException(id));
	}
	

	/**
	 * Metodo para listar eventos por su genero
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
	

	
	
	

	


}
