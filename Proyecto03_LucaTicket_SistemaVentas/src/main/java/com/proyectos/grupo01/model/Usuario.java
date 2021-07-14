package com.proyectos.grupo01.model;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Usuario {
	
	private int id_usuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String password;
	private LocalDate fecha_alta;

}
