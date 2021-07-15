package com.proyectos.grupo01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.proyectos.grupo01.error.UsuarioNotFoundException;

//import com.proyectos.grupo01.error.EventoNotFoundException;
//import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.repository.UsuarioRepository;

/**
 * Usuario Controller <br>
 * @author Desiree
 * @version 09/07/2021/A
 */
@RestController
@RequestMapping("/")
public class UsuarioController {
	
	private static final Logger log = Logger.getLogger("UsuarioRepository.class");
	
	@Autowired
	UsuarioRepository repo;
	
	
	/**
	 * Método para añadir un nuevo usuario a la base de datos
	 * @param usuarioRequest
	 * @return creado
	 * 
	 */
		@PostMapping("/usuario/save")
		public ResponseEntity <Usuario> addUsuario (@RequestBody Usuario usuarioRequest) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ADD USUARIO");
			log.infof("Request: ",usuarioRequest);
			
			Usuario usuario = repo.save(usuarioRequest);
			return new ResponseEntity <> (usuario, HttpStatus.CREATED);
		}
		
		 /**
	     * Método para EDITAR un usuario según su ID
	     * @param evento, id
	     * @return Usuario
	     * @author Desiree
	     * @version 14/07/2021
	     */
		@PutMapping("usuario/edit/{id}")
		public ResponseEntity<?> editarUsuario(@RequestBody Usuario usuario, @PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/EDITAR");
			log.info("----Editando usuario con ID = " + id);
			
			if(!repo.existsById(id)) {
				throw new UsuarioNotFoundException(id);
				
			}else {
				
				usuario.setNombre(usuario.getNombre());
				usuario.setApellido(usuario.getApellido());
				usuario.setMail(usuario.getMail());
				usuario.setUser_name(usuario.getUser_name());
				usuario.setPassword(usuario.getPassword());
				usuario.setFecha_alta(usuario.getFecha_alta());
				usuario.setToken(usuario.getToken());
				
				return ResponseEntity.ok(repo.save(usuario));
				
			}
			
		}	
			
			
//			
////					repo.findById(id).map(usuarioEdit -> {
////				
////				usuarioEdit.setNombre(usuario.getNombre());
////				usuarioEdit.setApellido(usuario.getApellido());
////				usuarioEdit.setFecha_alta(usuario.getFecha_alta());
////				usuarioEdit.setMail(usuario.getMail());
////				usuarioEdit.setUser_name(usuario.getUser_name());
////				
////				return ResponseEntity.ok(service.save(usuarioEdit));
////				
			
		
		 /**
	     * Método para dar de baja un usuario según su Id
	     * @author Desiree
	     * @version 14/07/2021
	     */
		@DeleteMapping("usuario/delete/{id}")
		public ResponseEntity<?> eliminarUsuario(@PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/BORRAR POR ID");
			log.info("----El evento con ID = " + id);
			int i; //para encontrar usuarios
			repo.deleteById(id);
			return ResponseEntity.noContent().build();
		}
			

		/**
		 * Metodo para listar un usuario por su ID
		 * 
		 * @param String
		 * @return usuario
		 * @author Desiree 
		 * @version 14/07/2021
		 */
		@GetMapping(value = "/usuario/{id}")
		public Usuario encontrarPorId(@PathVariable("id") int id) {
			log.info("---- Se ha invocado el microservicio GESTIÓN_USUARIOS/ENCONTRAR POR ID");
			Optional<Usuario> usuarioId = repo.findById(id);
			return usuarioId.orElseThrow(() -> new UsuarioNotFoundException(id));
		}


		


}
