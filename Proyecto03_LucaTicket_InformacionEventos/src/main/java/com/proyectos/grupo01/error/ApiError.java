package com.proyectos.grupo01.error;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiError {

@NonNull
private HttpStatus estado;
@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
private LocalDateTime fecha = LocalDateTime.now();
@NonNull
private String mensaje;

private List<String> errors;


public ApiError(HttpStatus status, String message, List<String> errors) {
    super();
    this.estado = status;
    this.mensaje = message;
    this.errors = errors;
}

public ApiError(HttpStatus status, String message, String error) {
    super();
    this.estado = status;
    this.mensaje = message;
    errors = Arrays.asList(error);
}


}
