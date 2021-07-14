package com.proyectos.grupo01.repository;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Evento;

@Repository
public interface EventoRepository extends MongoRepository <Evento, String> {

	
		@Query("{precioNormal : {$lt : ?0, $gt : ?1}}")
		List <Evento> findEventoByPriceRange(int desde, int hasta);
	    
}

