package com.azarel.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.azarel.client.controlExceptions.ResourceNotFoundException;
import com.azarel.client.model.ClienteModel;
import com.azarel.client.repositorio.ClienteRepositorio;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteRepositorio repositorio;

    public List<ClienteModel> listarTodos() {
        return repositorio.findAll();
    }

    public ClienteModel guardar(ClienteModel cliente) {
    	ClienteModel clienteGuardado = repositorio.save(cliente);
        return clienteGuardado;
    }

    public ClienteModel buscarPorId(Long id) {
        return repositorio.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        repositorio.deleteById(id);
    }
}
