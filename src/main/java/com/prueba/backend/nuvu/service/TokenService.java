package com.prueba.backend.nuvu.service;

public interface TokenService {
	
	String generateToken(String user);
	
	String validarToken(String token);

}
