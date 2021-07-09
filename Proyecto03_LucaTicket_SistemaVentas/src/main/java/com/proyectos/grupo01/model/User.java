package com.proyectos.grupo01.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
	
	private String user;
	private String pwd;
	private String token;
	

}