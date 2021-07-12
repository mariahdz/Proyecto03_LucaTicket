package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;

@SpringBootTest
public class EditTest {

	@MockBean
	private EventoController control;
	

	@Test
	public void whenEditEvento_shouldReturnOK() {
	Evento evento = new Evento();
	String id = "id";
	control.editarEvento(evento, id);
	assertThat(ResponseEntity.status(HttpStatus.OK));
	}
}
