package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;

/*
 * Clase EditTest
 * Testea el método de editar evento
 * @autor Desiree
 * @version 12/07/2021/A
 */


@SpringBootTest
@AutoConfigureMockMvc
public class EditTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	private EventoController control;
	
	@Qualifier
	private EventoRepository repo;
	
	@Before(value = "/")
	public void init() {
	MockitoAnnotations.initMocks(control);
	}
	
	
	
	/*
	 * Comprueba el método editar que devuelve un OK cuando se ejecuta
	 */
	@Test
	public void whenEditEvento_shouldReturnOK() {
	Evento evento = new Evento();
	String id = "id";
	control.editarEvento(evento, id);
	assertThat(ResponseEntity.status(HttpStatus.OK));
	}
	

	@Test
	public void test1() throws Exception {
		
		List <Evento> list = new ArrayList<>();
		Evento evento = new Evento ("212df5d5","Dream Beach", "Festival de musica", " ", LocalDate.now(),LocalDate.now(),"15:30h", 50, 100, list ," ", " ");
		
		String url = "/evento/edit/{id}";
		String port = "212df5d7";
		String url2 = String.format("http://localhost:2222/evento/edit/", port);
		mockMvc
		.perform(put(url2))
		.andDo(print())
		.andExpect(status().isNotFound());
	}
	

	
	@Test
	public void editTest() throws Exception {
		
		RequestBuilder request = MockMvcRequestBuilders
				.put("/evento/edit")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		assertThat(ResponseEntity.status(HttpStatus.OK));
		
	}
	
		

	
}
		

