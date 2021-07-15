package com.proyectos.grupo01.service;

import java.util.List;
import java.util.Optional;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;
/**
 * Evento Service
 * @author Daniela Posas
 * @version 09/07/2021/A
 *
 */
public interface EventoService extends EventoRepository {
	
	public List<Evento> findAll();
	public Optional<Evento> findById(String id);
	public boolean existsById(String id);
	public void deleteById(String id);
	void updateEvento(Evento evento);
	public Evento addEvento(Evento evento);
}
