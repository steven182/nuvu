package com.prueba.backend.nuvu.service;

import com.prueba.backend.nuvu.DTO.DtoCredenciales;

public interface LoginService {
	
	DtoCredenciales login(String correo, String contrasena);
	
	

}
