package com.prueba.backend.nuvu.service;

import java.util.List;

import com.prueba.backend.nuvu.model.TarjetaCredito;

public interface TarjetaCreditoService {

	TarjetaCredito saveOrUpdate(TarjetaCredito tarjetaCredito);
	
	List<TarjetaCredito> findAll();

}
