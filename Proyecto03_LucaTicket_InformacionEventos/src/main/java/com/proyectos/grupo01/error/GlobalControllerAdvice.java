package com.proyectos.grupo01.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler{

	/**
     * Exception que devuelve un NOT_FOUND para la petición GET de encontrar Evento por id
     * @param 
     * @return 
     * @author Daniela Posas
     */
	@ExceptionHandler(EventoNotFoundException.class)
	public ResponseEntity<ApiError>handleEventoNoEncontrado(EventoNotFoundException exceptionE){
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exceptionE.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	
	@ExceptionHandler(EventoNombreNotFoundException.class)
	public ResponseEntity<ApiError>handleEventoNombreNoEncontrado(EventoNombreNotFoundException exceptionE){
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exceptionE.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	@ExceptionHandler(EventoDescripcionNotFoundException.class)
	public ResponseEntity<ApiError>handleEventoDescripcionNoEncontrado(EventoDescripcionNotFoundException exceptionE){
		
		ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, exceptionE.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ApiError apiError = new ApiError(status, ex.getMessage());
		return ResponseEntity.status(status).headers(headers).body(apiError);
	}
	
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	  MethodArgumentNotValidException ex, 
	  HttpHeaders headers, 
	  HttpStatus status, 
	  WebRequest request) {
	    List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	    }
	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	    }
	    
	    ApiError apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return handleExceptionInternal(
	      ex, apiError, headers, apiError.getEstado(), request);
	}
	
	
	
	
	
	/**
     * Exception que devuelve un BAD_REQUEST para la petición PUT
     * @param 
     * @return 
     * @author Daniela Posas
     */

	/*@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<ApiError> handleJsonMappingException(JsonMappingException exceptionE){
	
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exceptionE.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
		
	}*/
}
