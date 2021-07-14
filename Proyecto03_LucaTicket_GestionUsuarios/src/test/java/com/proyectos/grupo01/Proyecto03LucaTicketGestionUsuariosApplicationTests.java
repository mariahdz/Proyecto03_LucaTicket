package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectos.grupo01.controller.UsuarioController;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.service.UsuarioServiceImpl;

@SpringBootTest
class Proyecto03LucaTicketGestionUsuariosApplicationTests {
	
	@Autowired
	UsuarioController control;
	
	@Autowired
	UsuarioServiceImpl service;

	@Test
	public void controllerTest() {
		assertThat(control).isNotNull();
	}
	
	@Test
	public void serviceTest () {
		assertThat(service).isNotNull();
	}
	
	
}
