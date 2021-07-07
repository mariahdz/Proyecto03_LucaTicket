package com.proyectos.grupo01.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.proyectos.grupo01.model.Evento;

public interface EventoRepository extends MongoRepository<Evento,String>{


}
