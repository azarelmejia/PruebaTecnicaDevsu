package com.azarel.client.repositorio;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.azarel.client.model.PersonaModel;

public interface PersonaRepositorio extends JpaRepository<PersonaModel, Integer> {
	
	/* Custom Query Buscar por Identificacion */
	
	 @Query("SELECT p FROM PersonaModel p WHERE p.identificacion = :identificacion")
	 Optional<PersonaModel> buscarPorIdentificacion(@Param("idCliente") Long idCliente);

	
}