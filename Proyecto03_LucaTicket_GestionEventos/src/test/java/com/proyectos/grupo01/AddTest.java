package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;

@SpringBootTest
class AddTest {
	
	@MockBean
	private EventoController control;
	

	@Test
	public void whenAddEvento_shouldReturnCREATED() {
	Evento evento = new Evento();
	control.addEvento(evento);
	assertThat(ResponseEntity.status(HttpStatus.CREATED));
	}
	
}
