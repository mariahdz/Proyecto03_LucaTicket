//package com.proyectos.grupo01.service;
//
//
//import java.util.Optional;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.proyectos.grupo01.model.Usuario;
//import com.proyectos.grupo01.repository.UsuarioRepository;
//
//public interface UsuarioService extends UsuarioRepository {
//	
//	public ResponseEntity <Usuario> addUsuario (@RequestBody Usuario usuarioRequest);
//	public Optional<Usuario> findById(Integer id);
//	public void deleteById(int id);
//	public <S extends Usuario> S save(S entity);
//
//	
//
//}
