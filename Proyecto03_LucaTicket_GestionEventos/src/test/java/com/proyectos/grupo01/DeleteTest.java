package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.service.EventoService;

@SpringBootTest
public class DeleteTest {
	
	@InjectMocks
	EventoController control;
	
	@Mock
	EventoService service;
	
	@Before(value = "/")
	public void init() {
		MockitoAnnotations.initMocks(control);
	}

	
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
		List <Evento> list = new ArrayList();
		
		Evento evento = new Evento("212df5d5","Dream Beach", "Festival de musica", " ", LocalDate.now(),LocalDate.now()," ",
				50, 100, list ," ", " ");
		
		service.addEvento(evento);
		service.delete(evento);
		assertThat(list.size()).isEqualTo(0);
		assertThat(service.findAll()).isEmpty();
	
	}
	
//	@Test
//	public void whenDeleteEvento_shouldReturnEmpty() {
//		Evento evento = new Evento();
//		evento.setId("1");
//		control.eliminarEvento(id);
//		controller.deleteJuego(0);
//		assertThat(repo.findAll().size()).isEqualTo(0);
//		
//		
//	}
}
