package com.prueba.backend.nuvu.model.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backend.nuvu.DTO.DtoResponse;
import com.prueba.backend.nuvu.model.Persona;
import com.prueba.backend.nuvu.service.PersonaService;
import com.prueba.backend.nuvu.service.TokenService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/savePersona")
	public ResponseEntity<?> savePersona(HttpServletRequest request, @RequestBody Persona persona) {
		String token = tokenService.validarToken(request.getHeader("token"));
		if (token.equals("Token Invalido") || token.equals("Token Fallido")) {
			return new ResponseEntity<>("No tiene autorización", HttpStatus.UNAUTHORIZED);
		}
		Persona personaTemp = personaService.saveOrUpdate(persona);
		return new ResponseEntity<DtoResponse<Persona>>(new DtoResponse<Persona>(personaTemp, "Persona creada correctamente"), HttpStatus.CREATED);
	}

	@GetMapping("/findAllPersona")
	public ResponseEntity<?> findAllPersona(HttpServletRequest request) {
		String token = tokenService.validarToken(request.getHeader("token"));
		if (token.equals("Token Invalido") || token.equals("Token Fallido")) {
			return new ResponseEntity<>("No tiene autorización", HttpStatus.UNAUTHORIZED);
		}
		List<Persona> listPersonas = personaService.findAll();
		return new ResponseEntity<DtoResponse<Persona>>(new DtoResponse<Persona>(listPersonas, "Listado de personas"),
				HttpStatus.OK);
	}

}
