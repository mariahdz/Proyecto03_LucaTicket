package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;

@SpringBootTest
public class DeleteTest {
	
	@Mock
	UsuarioController control;
	
	@Before(value = "/")
	public void init() {
		MockitoAnnotations.initMocks(control);
	}


	@Test
	public void whenDeleteUsuario_shouldReturnNoCONTENT() { 
	
	 Usuario usuario = new Usuario();
	 control.addUsuario(usuario);
     int id = 1;
     control.eliminarUsuario(id);
     assertThat(ResponseEntity.status(HttpStatus.NO_CONTENT));
	}
	
	@Test
	public void whenDeleteUsuario_shouldReturnEmptyLIST() { 
		List <Usuario> list = new ArrayList();
		
		Usuario usuario = new Usuario(1,"Luca-Tic","Luca", "Fernandez", "lucatic@gmail.com","a123456", LocalDate.now());
		
		control.addUsuario(usuario);
		control.eliminarUsuario(1);
		assertThat(list.size()).isEqualTo(0);
		//assertThat(control.findAll()).isEmpty();
	
	}
}
