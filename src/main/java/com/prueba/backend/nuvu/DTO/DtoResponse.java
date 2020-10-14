package com.prueba.backend.nuvu.DTO;

import java.io.Serializable;
import java.util.List;

public class DtoResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private T object;
	private List<T> listResult;
	private String mensaje;

	public DtoResponse(T object) {
		this.object = object;
	}

	public DtoResponse(List<T> listResult) {
		this.listResult = listResult;
	}

	public DtoResponse(String mensaje) {
		this.mensaje = mensaje;
	}

	public DtoResponse(T object, String mensaje) {
		this.object = object;
		this.mensaje = mensaje;
	}

	public DtoResponse(List<T> listResult, String mensaje) {
		this.listResult = listResult;
		this.mensaje = mensaje;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public List<T> getListResult() {
		return listResult;
	}

	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
