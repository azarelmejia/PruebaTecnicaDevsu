package com.azarel.client.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.azarel.client.controlExceptions.ResourceNotFoundException;
import com.azarel.client.model.ClienteModel;
import com.azarel.client.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/leer")
    public List<ClienteModel> listar() {
        return service.listarTodos();
    }

    @PostMapping("/crear")
    public ClienteModel crear(@RequestBody ClienteModel cliente) {
        return service.guardar(cliente);
    }

    @GetMapping("/{id}")
    public ClienteModel obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("actualizar/{id}")
    public ClienteModel actualizar(@PathVariable Long id, @RequestBody ClienteModel cliente) {
    	cliente.setIdcliente(id);
        return service.guardar(cliente);
    }

    @DeleteMapping("eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
         service.eliminar(id);
         return "success";
    }
}
