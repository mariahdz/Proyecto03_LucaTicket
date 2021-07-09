package com.proyectos.grupo01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.repository.UsuarioRepository;



@RestController
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repo;
	
	//Método añadir nuevo usuario
		@PostMapping("/save")
		public ResponseEntity <Usuario> addUsuario (@RequestBody Usuario usuarioRequest) {
		//	log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ADD USUARIO");
		//	log.infof("Request: ",usuarioRequest);
			
			Usuario usuario = repo.save(usuarioRequest);
			return new ResponseEntity <> (usuario, HttpStatus.CREATED);
			
		}


}
