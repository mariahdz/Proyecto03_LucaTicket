package com.proyectos.grupo01.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Evento;


public class EventoRepositoryImpl {

	
	/*private Map<String, Evento> eventos = new HashMap<String, Evento>();
	private static final Logger log = Logger.getLogger("AccountRepositoryImpl.class");
	
	public EventoRepositoryImpl() {
	
		Evento evento = new Evento("145-AST", "Antonio Herranz", " ", " ", 2,3," "," ");
		eventos.put("145-AST", evento);
	
		
		log.info("---- Se ha creado el repositorio EventoRepositoryImpl");
	}
*/

	public List<Evento> findAll() {
		return new ArrayList<Evento>();
	}
	
	
	public <S extends Evento> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<Evento> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Evento> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Evento> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}


	public <S extends Evento> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Evento> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Page<Evento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Evento> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Optional<Evento> findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean existsById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Iterable<Evento> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	
	public void delete(Evento entity) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteAll(Iterable<? extends Evento> entities) {
		// TODO Auto-generated method stub
		
	}

	
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	public <S extends Evento> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <S extends Evento> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}


	public <S extends Evento> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public <S extends Evento> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
