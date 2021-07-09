package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectos.grupo01.controller.EventoController;
<<<<<<< Updated upstream
//import com.proyectos.grupo01.controller.UserController;
=======

>>>>>>> Stashed changes
import com.proyectos.grupo01.repository.EventoRepository;

@SpringBootTest
class Proyecto03LucaTicketGestionEventosApplicationTests {

	@Autowired
	EventoController controller;
	
	@Autowired
	EventoRepository eventoRepository;

<<<<<<< Updated upstream
//	@Autowired
=======
	@Autowired
>>>>>>> Stashed changes
//	UserController control;
	
	@Test
	void testController() {
		
		assertThat(controller).isNotNull();
		
	}
	
	@Test
	void testRepo() {
		assertThat(eventoRepository).isNotNull();
	}
	
<<<<<<< Updated upstream
	
=======
//	
>>>>>>> Stashed changes
//	@Test
//	void testControl() {
//		assertThat(control).isNotNull();
//	}
<<<<<<< Updated upstream
	
=======
//	
>>>>>>> Stashed changes

}


