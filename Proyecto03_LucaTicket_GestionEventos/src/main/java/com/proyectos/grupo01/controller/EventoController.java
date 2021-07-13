package com.proyectos.grupo01.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;
import com.proyectos.grupo01.service.EventoService;

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

	@Autowired
	EventoService service;
	
	
	 /**
     * Método para CREAR un nuevo evento
     * @param eventoRequest
     * @return ResponseEntity
     * @author María Hernández
     */
	
	@PostMapping("/save")
	public ResponseEntity<Evento> addEvento(@RequestBody Evento eventoRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/ADD EVENTO");

		Evento evento = service.save(eventoRequest);
		return new ResponseEntity<>(evento, HttpStatus.CREATED);
	}

	
	 /**
     * Método para EDITAR un evento según su ID
     * @param evento, id
     * @return Evento
     * @author Daniela Posas
     */
	@PutMapping("evento/edit/{id}")
	public ResponseEntity<?> editarEvento(@RequestBody Evento evento, @PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/EDITAR");
		log.info("----Editando evento con ID = " + id);
		
		return eventoRepository.findById(id).map(eventoEdit -> {
			
			eventoEdit.setDescripcionCorta(evento.getDescripcionCorta());
			eventoEdit.setDescripcionExt(evento.getDescripcionExt());
			eventoEdit.setFechaFin(evento.getFechaFin());
			eventoEdit.setFechaInicio(evento.getFechaInicio());
			eventoEdit.setHora(evento.getHora());
			eventoEdit.setImage(evento.getImage());
			eventoEdit.setNombre(evento.getNombre());
			eventoEdit.setPoliticaAcceso(evento.getPoliticaAcceso());
			eventoEdit.setPrecioNormal(evento.getPrecioNormal());
			eventoEdit.setPrecioPreventa(evento.getPrecioPreventa());
			eventoEdit.setRecinto(evento.getRecinto());
			
			return ResponseEntity.ok(eventoRepository.save(eventoEdit));
			
		}).orElseGet(() ->{
			return ResponseEntity.notFound().build();
		});
	
	}
	
	
	 /**
     * Método para ELIMINAR un evento por su ID
     * @param id
     * @return Evento
     * @author Daniela Posas
     */

	@DeleteMapping("evento/delete/{id}")
	public ResponseEntity<?> eliminarEvento(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/BORRAR POR ID");
		log.info("----El evento con ID = " + id);
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
