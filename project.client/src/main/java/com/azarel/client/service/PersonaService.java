package com.azarel.client.service;

//import com.azarel.api.controlExceptions.ResourceNotFoundException;
import com.azarel.client.model.PersonaModel;
import com.azarel.client.repositorio.PersonaRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PersonaService {

    @Autowired
    private PersonaRepositorio repositorio;

    public List<PersonaModel> listarTodos() {
        return repositorio.findAll();
    }

    public boolean guardar(PersonaModel persona) {
    	
    	Integer idCliente = (persona.getIdcliente() != null) ? persona.getIdcliente().intValue() : 0;
    	
    	if (!repositorio.existsById(idCliente)) {
    		repositorio.save(persona);
            return true;
        } else {
            return false;
        }
    }

    public Optional<PersonaModel> buscarPorId(Long id) {
        return repositorio.buscarPorIdentificacion(id);
    }
    
    public boolean existedById(Integer id) {
    	return repositorio.existsById(id);
    }
    
    public boolean eliminarPorId(Integer id) {
        if (repositorio.existsById(id)) {
        	repositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean actualizar(PersonaModel persona) {
        if (repositorio.existsById(persona.getIdcliente().intValue())) {
        	repositorio.save(persona);
            return true;
        } else {
            return false;
        }
    }
    
    
}
