package com.proyectos.grupo01.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.model.User;
/**
 * Evento Repository
 * @author María Hernández
 * @version 07/07/2021/A
 *
 */
@Repository
public interface EventoRepository extends MongoRepository<Evento,String>{
	
}
