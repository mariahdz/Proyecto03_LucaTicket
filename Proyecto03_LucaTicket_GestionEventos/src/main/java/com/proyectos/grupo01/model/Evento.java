package com.proyectos.grupo01.model;

import java.awt.Image;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Document(collection = "Eventos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Evento {
	
	@Id
	@Type(type ="objectid")
	private String id;
	private String nombre;
	private String descripcionCorta;
	private String descripcionExt;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private LocalTime hora;
	private int precioPreventa;
	private int precioNormal;
	private String recinto;
	private String politicaAcceso;
	private Image image;
	
}
