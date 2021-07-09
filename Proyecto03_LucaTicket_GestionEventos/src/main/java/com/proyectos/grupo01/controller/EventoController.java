package com.proyectos.grupo01.controller;


import java.util.List;




import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
public class EventoController {
	
	private static final Logger log = Logger.getLogger("EventoRepositoryImpl.class");

	@Autowired
	EventoRepository eventoRepository;
	
	//Método añadir nuevo evento
	@PostMapping("/save")
	public ResponseEntity <Evento> addEvento (@RequestBody Evento eventoRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/ADD EVENTO");
		log.infof("Request: ",eventoRequest);
		
		Evento evento = eventoRepository.save(eventoRequest);
		return new ResponseEntity <> (evento, HttpStatus.CREATED);
		
	}

	
	@GetMapping("/evento/list")
	public Evento[] listarEventos() {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
		System.out.println("error");
		List <Evento> eventos = eventoRepository.findAll();
		log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
		log.error("error");
		
		return eventos.toArray(new Evento[eventos.size()]);
	}
	

	@GetMapping("/list")
	public Evento[] listarEventos2() {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
		System.out.println("error");
		List <Evento> eventos = eventoRepository.findAll();
		log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
		log.error("error");
		
		return eventos.toArray(new Evento[eventos.size()]);
	}
	
	@RequestMapping(path = "/test", method = RequestMethod.GET)
    public String testEndpoint() {
		System.out.println("error");
        return "Hello World!";
    }

}
