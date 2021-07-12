package com.proyectos.grupo01.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoDescripcionNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9204286015807282342L;
	/**
	 * 
	 */
	public EventoDescripcionNotFoundException(String descripcion) {
		super("No se puede encontrar el evento con la descripción: " + descripcion);
	}


	
}
