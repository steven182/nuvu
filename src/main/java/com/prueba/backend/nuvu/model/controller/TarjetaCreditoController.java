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
import com.prueba.backend.nuvu.model.TarjetaCredito;
import com.prueba.backend.nuvu.service.TarjetaCreditoService;
import com.prueba.backend.nuvu.service.TokenService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/tarjetaCredito")
public class TarjetaCreditoController {

	@Autowired
	private TarjetaCreditoService tarjetaCreditoService;

	@Autowired
	private TokenService tokenService;

	@PostMapping("/saveTarjetaCredito")
	public ResponseEntity<?> savePersona(HttpServletRequest request, @RequestBody TarjetaCredito tarjetaCredito) {
		String token = tokenService.validarToken(request.getHeader("token"));
		if (token.equals("Token Invalido") || token.equals("Token Fallido")) {
			return new ResponseEntity<>("No tiene autorización", HttpStatus.UNAUTHORIZED);
		}
		TarjetaCredito tarjetaCreditoTemp = tarjetaCreditoService.saveOrUpdate(tarjetaCredito);
		return new ResponseEntity<DtoResponse<TarjetaCredito>>(
				new DtoResponse<TarjetaCredito>(tarjetaCreditoTemp, "Tarjeta creada correctamente"),
				HttpStatus.CREATED);
	}

	@GetMapping("/findAllTarjetaCredito")
	public ResponseEntity<?> findAllPersona(HttpServletRequest request) {
		String token = tokenService.validarToken(request.getHeader("token"));
		if (token.equals("Token Invalido") || token.equals("Token Fallido")) {
			return new ResponseEntity<>("No tiene autorización", HttpStatus.UNAUTHORIZED);
		}
		List<TarjetaCredito> listTarjetaCredito = tarjetaCreditoService.findAll();
		return new ResponseEntity<DtoResponse<TarjetaCredito>>(
				new DtoResponse<TarjetaCredito>(listTarjetaCredito, "Listado de tarjetas de credito"), HttpStatus.OK);
	}
}
