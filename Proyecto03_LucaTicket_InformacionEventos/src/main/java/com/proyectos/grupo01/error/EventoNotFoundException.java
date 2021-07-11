package com.proyectos.grupo01.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5736795199669909031L;

	public EventoNotFoundException(String id) {
		super("No se puede encontrar el evento con el ID: " + id);
	}
}
