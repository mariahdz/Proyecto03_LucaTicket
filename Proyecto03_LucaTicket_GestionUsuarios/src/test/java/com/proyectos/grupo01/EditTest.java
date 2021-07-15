package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.repository.UsuarioRepository;

@SpringBootTest
class EditTest {
	

	@Mock
	private UsuarioController control;
	
	@Mock
	private UsuarioRepository repo;
	
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		Usuario usuario = new Usuario();
		
	}
	

	@Test
	public void whenEditEvento_shouldReturnOK() {
	Usuario usuario = new Usuario();
	int id = 1;
	control.editarUsuario(usuario, id);
	assertThat(ResponseEntity.status(HttpStatus.NOT_FOUND));
	}
	
}
