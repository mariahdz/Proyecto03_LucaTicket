package com.proyectos.grupo01.error;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global Controller Advice
 * @author Daniela Posas
 * @version 12/07/2021/A
 *
 */
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

		
		
		
		@Override
		protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
				HttpStatus status, WebRequest request) {
			ApiError apiError = new ApiError(status, ex.getMessage());
			return ResponseEntity.status(status).headers(headers).body(apiError);
		}
		
			
		/**
	     * Exception que devuelve un BAD_REQUEST para la petición PUT Y POST
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
