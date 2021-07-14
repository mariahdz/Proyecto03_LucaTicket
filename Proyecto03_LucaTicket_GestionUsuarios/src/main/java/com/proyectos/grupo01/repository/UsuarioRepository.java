package com.proyectos.grupo01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.proyectos.grupo01.model.Usuario;

/**
 * Usuario Repository<br>
 * @author María Hernández
 * @version 07/07/2021/A
 */
@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
	

}
