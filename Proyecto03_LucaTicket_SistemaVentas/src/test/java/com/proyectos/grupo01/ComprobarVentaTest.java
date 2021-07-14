package com.proyectos.grupo01;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.proyectos.grupo01.controller.VentaController;

@SpringBootTest
public class ComprobarVentaTest {

	@MockBean
	private VentaController control;
	

	/*@Test
	private void asserThat(ResponseEntity<Boolean> venta) {
		
		 Evento evento = new Evento();
		 String eventoId = evento.getId();
		 
		 venta = control.comprobarVenta(eventoId);
		
		
		asserThat(venta==true);		
	}*/
	
}
