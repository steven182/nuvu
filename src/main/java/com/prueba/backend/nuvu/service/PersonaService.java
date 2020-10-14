package com.prueba.backend.nuvu.service;

import java.util.List;

import com.prueba.backend.nuvu.model.Persona;

public interface PersonaService {

	Persona saveOrUpdate(Persona persona);

	List<Persona> findAll();

}
