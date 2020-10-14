package com.prueba.backend.nuvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.prueba.backend.nuvu.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
	@Query("select p from Persona p where p.correo=:correo and p.contrasena=:contrasena")
	Persona login(@Param("correo")String correo, @Param("contrasena") String contrasena);

}
