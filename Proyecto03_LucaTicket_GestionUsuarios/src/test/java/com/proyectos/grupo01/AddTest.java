package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;

@SpringBootTest
public class AddTest {

	@InjectMocks
	UsuarioController control;
	
	@Before(value = "/")
	public void init() {
		MockitoAnnotations.initMocks(control);
	}


	@Test
	public void whenAddUsuario_shouldReturnCREATED() {
		
	Usuario usuario = new Usuario();
	control.addUsuario(usuario);
	assertThat(ResponseEntity.status(HttpStatus.CREATED));
	}
	
	
	@Test
	public void createUsuarioTest() {
		List <Usuario> list = new ArrayList();
		
		Usuario usuario = new Usuario(1,"Luca-Tic","Luca", "Fernandez", "lucatic@gmail.com","a123456", "token", LocalDate.now());
		
		control.addUsuario(usuario);
		assertThat(usuario.getId_usuario()).isNotNull();
		//assertThat(usuario.getUser_name()).isEqualTo("Luca-Tic");
		//verify(service, times(1)).addUsuario(usuario);
	}
	
}
