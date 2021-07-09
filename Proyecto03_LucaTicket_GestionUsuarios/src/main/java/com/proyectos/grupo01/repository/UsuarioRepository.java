package com.proyectos.grupo01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyectos.grupo01.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {

}
