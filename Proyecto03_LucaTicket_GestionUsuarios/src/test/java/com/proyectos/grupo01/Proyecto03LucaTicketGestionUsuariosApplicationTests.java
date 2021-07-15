package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectos.grupo01.controller.UsuarioController;



@SpringBootTest
class Proyecto03LucaTicketGestionUsuariosApplicationTests {
	
	@Autowired
	UsuarioController control;
	
	
	@Test
	public void controllerTest() {
		assertThat(control).isNotNull();
	}
	
	
}
