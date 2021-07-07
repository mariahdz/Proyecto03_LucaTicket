package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;

@SpringBootTest
class AddTest {
	
	@MockBean
	private EventoController control;
	

	@Test
	public void whenAddEvento_shouldReturnEvento() {
	Evento evento = new Evento();
	evento.setNombre("Test Evento");
	control.addEvento(evento);
	assertThat(evento.getNombre().contains("Test Evento"));
	}

}
