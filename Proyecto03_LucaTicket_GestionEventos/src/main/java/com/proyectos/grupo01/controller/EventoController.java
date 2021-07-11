package com.proyectos.grupo01.controller;


import java.util.List;




import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     * Metodo para CREAR un nuevo evento
     * @param eventoRequest
     * @return ResponseEntity
     */
	@PostMapping("/save")
	public ResponseEntity <Evento> addEvento (@RequestBody Evento eventoRequest) {
		log.info("---- Se ha invocado el microservicio GESTIÓN_EVENTOS/ADD EVENTO");
		log.infof("Request: ",eventoRequest);
		
		Evento evento = eventoRepository.save(eventoRequest);
		return new ResponseEntity <> (evento, HttpStatus.CREATED);
		
	}

	
	 /**
     * Metodo para EDITAR un evento segun su ID
     * @param evento, id
     * @return Evento
     * @author Daniela Posas
     */
	/*@PutMapping("evento/edit/{id}")
	public Evento editarEvento(@RequestBody Evento evento, @PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/EDITAR");
		log.info("----Editando evento con ID = " + id);
		if(service.existsById(id)){
			evento.setId(id);
			service.updateEvento(evento);
			return evento;
		}else {
			return null;
		}
	
	}*/
	
	@PutMapping("evento/edit/{id}")
	public ResponseEntity<?> editarEvento(@RequestBody Evento evento, @PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/EDITAR");
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
     * Metodo para ELIMINAR un evento por su ID
     * @param id
     * @return Evento
     * @author Daniela Posas
     */
	/*@DeleteMapping("evento/delete/{id}")
	public Evento eliminarEvento(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/BORRAR POR ID");
		log.info("----El evento con ID = " + id);
		if(service.existsById(id)){
			Evento evento = service.findById(id).get();
			service.deleteById(id);
			return evento;
		}else {
			return null;
		}
	}*/
	
	@DeleteMapping("evento/delete/{id}")
	public ResponseEntity<?> eliminarEvento(@PathVariable("id") String id) {
		log.info("---- Se ha invocado el microservicio INFORMACIÓN_EVENTOS/BORRAR POR ID");
		log.info("----El evento con ID = " + id);
		service.deleteById(id);
		return ResponseEntity.noContent().build();
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
