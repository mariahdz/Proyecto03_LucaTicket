package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.proyectos.grupo01.error.UsuarioNotFoundException;
import com.proyectos.grupo01.model.Usuario;
import com.proyectos.grupo01.repository.UsuarioRepository;
import org.jboss.logging.Logger;


/*
 * ListTest
 * @autor Daniela
 * @version 12/07/2021/A
 * Esta clase prueba el método y las excepción de encontrar usuario por ID
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FindByIdTest {

	@MockBean
	UsuarioRepository repository;

	@Autowired
	private MockMvc mockMvc;

	private static final Logger log = Logger.getLogger(FindByIdTest.class);

	
	
	@Test
	public void findByIdTest() throws Exception {

		Optional<Usuario> usuario = Optional.of(new Usuario());
		when(repository.findById(1)).thenReturn(usuario);

		assertThat(repository.findById(1)).isPresent();
	}

	
	@Test
	public void getUsertById_success() throws Exception {

		Optional<Usuario> usuario = Optional.of(new Usuario(1, "usuario1", "María", "Hernández", "maria@gmail.com",
				"password", LocalDate.now()));
		Mockito.when(repository.findById(usuario.get().getId_usuario())).thenReturn(usuario);

		mockMvc.perform(MockMvcRequestBuilders.get("/usuario/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.nombre", is("María")));
	}

	
	@Test
	public void usuarioNotFoundExceptionTest() {

		when(repository.findById(1)).thenThrow(new UsuarioNotFoundException(1));
		try {
			mockMvc.perform(get("/usuario/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
		} catch (Exception ex) {
			log.debug("exception caught @" + ex);
		}
	}
	


}
