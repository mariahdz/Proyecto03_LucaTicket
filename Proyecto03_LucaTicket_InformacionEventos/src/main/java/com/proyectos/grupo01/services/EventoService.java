package com.proyectos.grupo01.services;

import java.util.List;
import java.util.Optional;



import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;


public interface EventoService extends EventoRepository {
	
	public List<Evento> findAll();
	public List<Evento> findByGenero(String genero);
	public Optional<Evento> findById(String id);

}
