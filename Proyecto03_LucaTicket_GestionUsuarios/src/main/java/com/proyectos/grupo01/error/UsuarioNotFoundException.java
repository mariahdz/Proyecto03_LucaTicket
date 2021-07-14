package com.proyectos.grupo01.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EventoNotFoundException
 * @author Daniela Posas
 * @version 12/07/2021/A
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2120446279379926584L;

	public UsuarioNotFoundException(int id) {
		super("No se puede encontrar el usuario con el ID: " + id);
	}
}
