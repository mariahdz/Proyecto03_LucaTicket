package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.services.EventoService;

/*
 * ListTest
 * @autor Desiree
 * @version 09/07/2021/A
 * Esta clase prueba los métodos de listar
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ListTest {
	
	@MockBean
	EventoService service;
	
	
	/*
	 * Prueba el método FindAll si a lista está vacía
	 */
	@Test
	void testEmptyList() {
	        when(service.findAll()).thenReturn(new ArrayList<>());
	        assertThat(service.findAll()).isEmpty();
	        verify(service, times(1)).findAll();
	    }
	
	/*
	 * Prueba el método findAll con la lista llena
	 */
	@Test
	void testFindAll() {
		
		Evento evento = new Evento();
		when(service.findAll()).thenReturn(Collections.singletonList(evento));
		assertThat(service.findAll().size()).isEqualTo(1);
	}

	
	/*
	 * Prueba el método findById
	 */
	@Test
	void testFindById() {
		Optional<Evento> evento = Optional.of(new Evento());
		when(service.findById(String.valueOf(1))).thenReturn(evento);
		assertThat(service.findById(String.valueOf(1)).isPresent());
	}
	
	
	/*
	 * Prueba el método findByGenero
	 */
	@Test
	void testFindByGenero() {
		
		Evento evento = new Evento();
		when(service.findByGenero("rock")).thenReturn(Collections.singletonList(evento));
		assertThat(service.findByGenero("rock").size()).isEqualTo(1);
	}
	
	/*
	 * Prueba el método findByNombre
	 */
	@Test
	void testFindByNombre() {
		
		Evento evento = new Evento();
		when(service.findByName("Resurrection")).thenReturn(Collections.singletonList(evento));
		assertThat(service.findByName("Resurrection").size()).isEqualTo(1);
	}
	
}



