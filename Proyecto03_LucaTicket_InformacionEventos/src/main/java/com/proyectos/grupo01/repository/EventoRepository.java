package com.proyectos.grupo01.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Evento;

public interface EventoRepository extends MongoRepository <Evento, String> {

	
	public List <Evento> findAll();
	public Optional<Evento> findById(String id);
	public List <Evento> findByGenero(String genero);

}
