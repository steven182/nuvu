package com.prueba.backend.nuvu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.backend.nuvu.model.TarjetaCredito;
import com.prueba.backend.nuvu.repository.TarjetaCreditoRepository;

@Service
public class TarjetaCreditoServiceImpl implements TarjetaCreditoService {

	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;

	@Override
	public TarjetaCredito saveOrUpdate(TarjetaCredito tarjetaCredito) {
		return tarjetaCreditoRepository.save(tarjetaCredito);
	}

	@Override
	public List<TarjetaCredito> findAll() {
		return tarjetaCreditoRepository.findAll();
	}

}
