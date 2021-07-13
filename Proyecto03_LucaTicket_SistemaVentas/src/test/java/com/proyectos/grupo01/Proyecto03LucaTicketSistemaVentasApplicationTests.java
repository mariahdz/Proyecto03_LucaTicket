package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectos.grupo01.controller.VentaController;

@SpringBootTest
class Proyecto03LucaTicketSistemaVentasApplicationTests {

	@Autowired
	VentaController controller;
	
	@Test
	void testController() {
		
		assertThat(controller).isNotNull();
		
	}
}
