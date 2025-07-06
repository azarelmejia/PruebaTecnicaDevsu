package com.azarel.client.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import com.azarel.client.model.ClienteModel;

public interface ClienteRepositorio extends JpaRepository<ClienteModel, Long> {
	
}
