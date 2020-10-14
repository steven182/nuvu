package com.prueba.backend.nuvu.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.backend.nuvu.DTO.DtoCredenciales;
import com.prueba.backend.nuvu.service.LoginService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/seguridad")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody DtoCredenciales credenciales) {
		DtoCredenciales credencialesTemp = loginService.login(credenciales.getUsuario(), credenciales.getContrasena());
		if (credencialesTemp.isUserEmpty()) {
			return new ResponseEntity<>(credencialesTemp, HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(credencialesTemp, HttpStatus.OK);
		}

	}

}
