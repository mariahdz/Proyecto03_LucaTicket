package com.proyectos.grupo01.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;

public class EventoRepositoryImpl implements EventoRepository{

	
	public <S extends Evento> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Evento> findAll() {
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
