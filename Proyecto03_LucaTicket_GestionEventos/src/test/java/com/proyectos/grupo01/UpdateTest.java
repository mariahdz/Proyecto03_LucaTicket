package com.proyectos.grupo01;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.proyectos.grupo01.controller.EventoController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.service.EventoService;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;


public class UpdateTest {

	
@InjectMocks
Optional<Evento> eventoMocks;

@Mock
EventoService eventoServiceMock;

@Mock 
EventoController eventoControllerMock;


@Before(value = "")
public void init() {
	MockitoAnnotations.initMocks(this);
}
	
@Test
public void findByIdTest() {
	when(eventoServiceMock.findById("1232434dsfg")).thenReturn(eventoMocks);
	
			
	
}
	
	
	
/*@Test
public void encuentraEventoTest() {
	Evento eventoMock = mock(Evento.class);
	EventoService eventoServiceMock = mock(EventoService.class);
	String id;
	EventoController eventoControllerMock = mock(EventoController.class);
given(eventoControllerMock.editarEvento(eventoMock, id)).thenReturn(eventoServiceMock.findById(id)).thenReturn(eventoMock);
}*/

@Test
public void test_ResponseHeaderData_ShouldBeCorrect() {
        
    given().pathParam("evento", "id")
    .when().get("localhost:2222/evento/edit/{id}").
    then().
        assertThat().
        statusCode(200);
  
}
	

	
	
}
