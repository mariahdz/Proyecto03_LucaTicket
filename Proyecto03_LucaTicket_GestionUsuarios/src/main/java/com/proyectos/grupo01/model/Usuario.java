package com.proyectos.grupo01.model;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/**
 * Clase: Usuario <br>
 * Descripción: Esta clase es el modelo de datos para la administración de usuarios
 * @author Desiree
 * @version 09/07/2021/A
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	private String user_name;
	private String nombre;
	private String apellido;
	private String mail;
	private String password;
	private String token;
	private LocalDate fecha_alta;

}
