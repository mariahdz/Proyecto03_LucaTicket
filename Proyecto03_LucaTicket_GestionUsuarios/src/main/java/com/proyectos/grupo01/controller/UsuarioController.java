package com.proyectos.grupo01.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import com.proyectos.grupo01.error.EventoNotFoundException;
//import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.service.UsuarioServiceImpl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
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

		
		@PostMapping("/user")
		public Usuario login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
			
			String token = getJWTToken(username);
			Usuario user = new Usuario();
			user.setUser_name(username);
			//No encriptado
			user.setPassword(pwd);
			user.setToken(token);		
			return user;
			
		}
		
		private String getJWTToken(String username) {
			String secretKey = "mySecretKey";
			List<GrantedAuthority> grantedAuthorities = AuthorityUtils
					.commaSeparatedStringToAuthorityList("ROLE_USER");
			
			String token = Jwts
					.builder()
					.setId("softtekJWT")
					.setSubject(username)
					.claim("authorities",
							grantedAuthorities.stream()
									.map(GrantedAuthority::getAuthority)
									.collect(Collectors.toList()))
					.setIssuedAt(new Date(System.currentTimeMillis()))
					.setExpiration(new Date(System.currentTimeMillis() + 600000))
					.signWith(SignatureAlgorithm.HS512,
							secretKey.getBytes()).compact();

			return "Bearer " + token;
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
