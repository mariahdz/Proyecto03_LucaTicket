package com.proyectos.grupo01.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionExt;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalDate hora;
	private int precioPreventa;
	private int precioNormal;
	private List recinto;
	private String politicaAcceso;
	private String image;
	
	
	public List getRecinto(){
	    return this.recinto;
	}

	public void setRecinto(List recinto){
	    this.recinto = recinto;
	}
}