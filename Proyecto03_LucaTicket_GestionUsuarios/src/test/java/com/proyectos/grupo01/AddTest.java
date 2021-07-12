package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;

@SpringBootTest
public class AddTest {

	
	@MockBean
	private UsuarioController control;
	

	@Test
	public void whenAddUsuario_shouldReturnCREATED() {
	Usuario usuario = new Usuario();
	control.addUsuario(usuario);
	assertThat(ResponseEntity.status(HttpStatus.CREATED));
	}
	
}
