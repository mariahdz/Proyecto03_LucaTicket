package com.proyectos.grupo01.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Evento;

@Repository
public interface EventoRepository extends MongoRepository <Evento, String> {



}
