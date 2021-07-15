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

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.service.EventoService;

@SpringBootTest
class AddTest {
	
	@InjectMocks
	EventoController control;
	
	@Mock
	EventoService service;
	
	@Before(value = "/")
	public void init() {
		MockitoAnnotations.initMocks(control);
	}

	@Test
	public void whenAddEvento_shouldReturnCREATED() {
		
	Evento evento = new Evento();
	control.addEvento(evento);
	assertThat(ResponseEntity.status(HttpStatus.CREATED));
	}
	
	@Test
	public void createEventoTest() {
		List <Evento> list = new ArrayList();
		
		Evento evento = new Evento("212df5d5","Dream Beach", "Festival de musica", " ", LocalDate.now(),LocalDate.now(),LocalDate.now(),
				50, 100, list ," ", " ");
		
		service.addEvento(evento);
		assertThat(evento.getId()).isNotNull();
		assertThat(evento.getNombre()).isEqualTo("Dream Beach");
		verify(service, times(1)).addEvento(evento);
	}
	
}
