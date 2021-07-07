package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;

@SpringBootTest
class AddTest {
	
	@MockBean
	private EventoRepository repo;
	

	@Test
	public void whenAddEvento_shouldReturnEvento() {
	Evento evento = new Evento();
	evento.setNombre("Test Evento");
	repo.save(evento);
	assertThat(evento.getNombre().contains("Test Evento"));
	}

}
