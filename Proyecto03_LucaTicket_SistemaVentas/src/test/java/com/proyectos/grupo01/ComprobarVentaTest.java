package com.proyectos.grupo01;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.proyectos.grupo01.controller.VentaController;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.Usuario;

@SpringBootTest
public class ComprobarVentaTest {

	@MockBean
	private VentaController control;
	
	/*@Test
	public void whenComprobarVenta_shouldReturnOK() { 
	
	 Evento evento = new Evento();
	 Usuario user = new Usuario();
	 int idUsuario = user.getId_usuario();
	 String nombre = "nombre";
	 boolean venta = control.comprobarVenta(nombre, idUsuario);
     
     assertThat(ResponseEntity.status(HttpStatus.OK));
	}*/

	@Test
	private void asserThat(boolean venta) {
		
		 Evento evento = new Evento();
		 Usuario user = new Usuario();
		 int idUsuario = user.getId_usuario();
		 String nombre = "nombre";
		 venta = control.comprobarVenta(nombre, idUsuario);
		
		
		asserThat(venta==true);		
	}
	
}
