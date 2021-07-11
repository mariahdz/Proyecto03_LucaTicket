package com.proyectos.grupo01.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyectos.grupo01.model.Evento;
import com.proyectos.grupo01.repository.EventoRepository;

@Service
@Transactional
public class EventoServiceImpl implements EventoService {

	@Autowired
	EventoRepository eventoRepository;

	@Autowired
	MongoTemplate mongo;

	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}

	public Optional<Evento> findById(String id) {
		return eventoRepository.findById(id);
	}

	public boolean existsById(String id) {
		return eventoRepository.existsById(id);
	}

	public void deleteById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		mongo.remove(query, Evento.class);
	}

	public void updateEvento(Evento evento) {
		eventoRepository.save(evento);
	}

	@Override
	public <S extends Evento> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Evento> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> S insert(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Evento> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Evento> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Evento entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Evento> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Evento> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Evento> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Evento> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
