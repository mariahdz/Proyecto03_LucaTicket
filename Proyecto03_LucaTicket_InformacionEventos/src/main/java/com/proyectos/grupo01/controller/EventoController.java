package com.proyectos.grupo01.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
public class EventoController {
	
private static final Logger log = Logger.getLogger("EventoRepositoryImpl.class");

	
	@Autowired
	EventoRepository eventoRepository;
	
	@GetMapping("/eventos")
	public Evento[] listarEventos() {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS");
		List <Evento> eventos = eventoRepository.findAll();
		log.info("---- El microservicio INFORMACIÓN_EVENTOS/LISTAR EVENTOS ha encontrado: " + eventos.size() + " valores");
		return eventos.toArray(new Evento[eventos.size()]);
	}

}
