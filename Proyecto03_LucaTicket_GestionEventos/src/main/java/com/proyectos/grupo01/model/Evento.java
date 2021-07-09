package com.proyectos.grupo01.model;

<<<<<<< Updated upstream

=======
import java.awt.Image;
>>>>>>> Stashed changes
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
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
<<<<<<< Updated upstream
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
=======
public class Evento implements Serializable {
	
	private static final long serialVersionUID = 1L; 
>>>>>>> Stashed changes
	
	@Id
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
