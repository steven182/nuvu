package com.prueba.backend.nuvu.service;

import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenServiceImpl implements TokenService {

	Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);

	private static String id = "2550";
	private static String key = "U+k/qu1I+5KEwAFSj4T1fDXnudv0wV9YSg3SUd+i5j0=";
	private static String subject = "Prueba Tecnica";

	@Override
	public String generateToken(String user) {
		Instant now = Instant.now();
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] keySecret = DatatypeConverter.parseBase64Binary(key);
		Key signingKey = new SecretKeySpec(keySecret, signatureAlgorithm.getJcaName());

		String builder = Jwts.builder().setId(id).setSubject(subject).setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(60, ChronoUnit.MINUTES))).setIssuer(user)
				.signWith(signingKey, signatureAlgorithm).compact();
		return builder;
	}

	@Override
	public String validarToken(String token) {
		Jws<Claims> jws;
		try {
			jws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("Token Fallido = <" + token + ">");
			return "Token Fallido";
		}
		if ((!jws.getBody().getId().equals(id)) || (!jws.getBody().getSubject().equals(subject))) {
			logger.error("Token Invalido = " + token);
			return "Token Invalido";
		}

		return generateToken(jws.getBody().getIssuer());
	}

}
