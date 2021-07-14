package com.proyectos.grupo01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//import com.proyectos.grupo01.error.EventoNotFoundException;
//import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.service.UsuarioServiceImpl;
/**
 * Usuario Controller <br>
 * @author Desiree
 * @version 09/07/2021/A
 */
@RestController
public class UsuarioController {
	
	private static final Logger log = Logger.getLogger("UsuarioRepository.class");
	
	@Autowired
	UsuarioServiceImpl service;
	

	
	/**
	 * Método para añadir un nuevo usuario a la base de datos
	 * @param usuarioRequest
	 * @return
	 * @author Desiree
	 */
		@PostMapping("/save")
		public ResponseEntity <Usuario> addUsuario (@RequestBody Usuario usuarioRequest) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ADD USUARIO");
			log.infof("Request: ",usuarioRequest);
			
			Usuario usuario = service.save(usuarioRequest);
			return new ResponseEntity <> (usuario, HttpStatus.CREATED);
		}

		



		/**
		 * Método para encontrar un usuario por su ID
		 * @param id
		 * @return usuario
		 * @author Desiree
		 */
		@GetMapping(value = "/{id}")
		public Optional <Usuario> encontrarPorId(@PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ENCONTRAR POR ID");
			Optional<Usuario> usuarioId = service.findById(id);
			return usuarioId;
		}


}
