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

import com.proyectos.grupo01.error.EventoDescripcionNotFoundException;
import com.proyectos.grupo01.error.EventoNombreNotFoundException;
import com.proyectos.grupo01.error.EventoNotFoundException;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.services.EventoService;


/**
 * Controller
 * @author María Hernández
 * @version 07/07/2021/A
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
	 * @author Desiree 
	 * @version 12/07/2021
	 */
	@GetMapping(value = "/evento/{id}")
	public Evento encontrarPorId(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR POR ID");
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
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR POR GÉNERO MÚSICA");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos = service.findByGenero(descripcionCorta);
		
		if(eventos.isEmpty()) {
			throw new EventoDescripcionNotFoundException(descripcionCorta);
		}
		
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
//	
//	@GetMapping(value="/evento/price/{price}")
//	public Evento encontrarPorPrecio(@PathVariable("precio") int precio) {
//		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR POR PRECIO");
//		Optional<Evento> eventoPrice = service.findOne(null)
//
//	}



	/**
	 * Metodo para listar eventos por su nombre
	 * 
	 * @param String
	 * @return Evento[]
	 * @author
	 */
	@GetMapping(value = "/eventos/list/{nombre}")
	public ResponseEntity<List<Evento>> encontrarPorNombre(@PathVariable("nombre") String nombre) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR POR NOMBRE");
		List<Evento> eventos = new ArrayList<Evento>();

		eventos = service.findByName(nombre);
		
		if(eventos.isEmpty()) {
			throw new EventoNombreNotFoundException(nombre);
		}

		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	

	/**
	 * Metodo para listar los eventos por un rango de precios determinado <br>
	 * @param desde
	 * @param hasta
	 * @return lista de eventos
	 * @author María Hernández
	 */
	
	@GetMapping(value = "/rango/precio/{desde}/{hasta}")
	public ResponseEntity<List<Evento>> listaRangoPrecios(@PathVariable int desde, @PathVariable int hasta) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR EVENTOS POR RANGO DE PRECIOS");
		List<Evento> eventos = new ArrayList<Evento>();

		eventos = service.findEventoByPriceRange(desde, hasta);
		
		/*if(eventos.isEmpty()) {
			throw new EventoNombreNotFoundException(hasta);
		}*/

		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}
	
	/**
	 * Metodo para listar todos los eventos de la colección
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
	
	
	@GetMapping(value = "/list/recinto/{recinto}")
	public ResponseEntity<List<Evento>> encontrarPorCiudad(@PathVariable("recinto") String recinto) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/ENCONTRAR POR CIUDAD");
		List<Evento> eventos = new ArrayList<Evento>();
		eventos = service.findByCiudad(recinto);
		
		if(eventos.isEmpty()) {
			throw new EventoDescripcionNotFoundException(recinto);
		}
		
		return new ResponseEntity<>(eventos, HttpStatus.OK);
	}

	
	
	
}
