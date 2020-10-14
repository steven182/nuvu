package com.prueba.backend.nuvu.DTO;

import java.io.Serializable;

public class DtoCredenciales implements Serializable {

	private static final long serialVersionUID = 1L;

	private String usuario;
	private String nombre;
	private String token;
	private String contrasena;
	private Long idPersona;
	private boolean userEmpty = false;

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean isUserEmpty() {
		return userEmpty;
	}

	public void setUserEmpty(boolean userEmpty) {
		this.userEmpty = userEmpty;
	}

}
