package com.prueba.backend.nuvu.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backend.nuvu.DTO.DtoCredenciales;
import com.prueba.backend.nuvu.model.Persona;
import com.prueba.backend.nuvu.repository.PersonaRepository;

@Service
public class LoginServiceImpl implements LoginService {

	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private TokenService tokenService;

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private EncriptarContrasena encriptar;

	@Override
	public DtoCredenciales login(String correo, String contrasena) {
		DtoCredenciales credencial = new DtoCredenciales();
		String contrasenaEncriptada = encriptar.encriptar(contrasena);
		Persona persona = personaRepository.login(correo, contrasenaEncriptada);
		if (persona != null) {
			logger.info("El usuario existe");
			credencial.setIdPersona(persona.getIdPersona());
			credencial.setUsuario(correo);
			credencial.setToken(tokenService.generateToken(correo));
			return credencial;
		} else {
			credencial.setUserEmpty(true);
			return credencial;
		}
	}

}
