package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.repository.UsuarioRepository;

@SpringBootTest
public class SaveTest {
	
	@Autowired
	UsuarioController control;
	
	@Autowired
	UsuarioRepository repo;
	
	@Test
	public void whenDeleteJuego_shouldReturnEmpty() {
		Usuario usuario = new Usuario();
		usuario.setId_usuario(1);
		control.addUsuario(usuario);
		control.eliminarUsuario(1);
		assertThat(repo.findAll().size()).isEqualTo(0);	
		
	}

}
