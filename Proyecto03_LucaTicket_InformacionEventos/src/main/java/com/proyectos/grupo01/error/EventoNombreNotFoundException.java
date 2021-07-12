package com.proyectos.grupo01.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EventoNombreNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7786913498439388117L;

	public EventoNombreNotFoundException(String name) {
		super("No se puede encontrar el evento con el nombre: " + name);
	}


}