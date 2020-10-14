package com.prueba.backend.nuvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backend.nuvu.model.Persona;
import com.prueba.backend.nuvu.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private EncriptarContrasena encriptarContrasena;

	@Override
	public Persona saveOrUpdate(Persona persona) {
		persona.setContrasena(encriptarContrasena.encriptar(persona.getContrasena()));
		return personaRepository.save(persona);
	}

	@Override
	public List<Persona> findAll() {
		return personaRepository.findAll();
	}

}
