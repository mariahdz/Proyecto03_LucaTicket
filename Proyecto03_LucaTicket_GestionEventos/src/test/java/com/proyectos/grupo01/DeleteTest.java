package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;

@SpringBootTest
public class DeleteTest {
	
	@MockBean
	private RestTemplate restTemplate;
	
	@MockBean
	private EventoController control;
	
	@Test
	public void whenDeleteEvento_shouldReturnNoCONTENT() { 
	
	 Evento evento = new Evento();
	 control.addEvento(evento);
     String id = "id";
     control.eliminarEvento(id);
     assertThat(ResponseEntity.status(HttpStatus.NO_CONTENT));
	}
	
	@Test
	public void whenDeleteEvento_shouldReturnEmptyLIST() { 
	
	 Evento evento = new Evento();
	 control.addEvento(evento);
     String id = "id";
     control.eliminarEvento(id);
     assertThat(ResponseEntity.status(HttpStatus.NO_CONTENT));
	}
}
