package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;

@SpringBootTest
class EditTest {

	@MockBean
	private UsuarioController control;
	

	@Test
	public void whenEditEvento_shouldReturnOK() {
	Usuario usuario = new Usuario();
	int id = 1;
	control.editarUsuario(usuario, id);
	assertThat(ResponseEntity.status(HttpStatus.NOT_FOUND));
	}
	
	
	@Test
	public void whenEditUsuaro_shouldReturnUsuarioModified() {
	Usuario usuario = new Usuario();
	when(control.editarUsuario(usuario, 1).getHeaders());
	control.editarUsuario(usuario, 1);
	assertThat(ResponseEntity.status(HttpStatus.OK));
	}

}
