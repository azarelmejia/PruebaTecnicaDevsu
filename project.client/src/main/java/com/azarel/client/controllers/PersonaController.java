package com.azarel.client.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azarel.client.model.PersonaModel;
import com.azarel.client.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService service;

    @GetMapping("/leer")
    public List<PersonaModel> listar() {
        return service.listarTodos();
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crear(@RequestBody PersonaModel persona) {
    	boolean registrado = service.guardar(persona);
        if (registrado) {
            return ResponseEntity.ok("Registrado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("OCurrio un error al registrar la persona: " + persona.getIdentificacion());
        }
    }

    @GetMapping("/{id}")
    public PersonaModel obtenerPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("No se encontró persona con ID: " + id));
    }


    @PutMapping("actualizar/{id}")
    public ResponseEntity<String> actualizar(@PathVariable String id, @RequestBody PersonaModel persona) {
    	
    	persona.setIdentificacion(id);
    	boolean uodated = service.actualizar(persona);
        if (uodated) {
            return ResponseEntity.ok("Actualizado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ocurrio un error al actualizar datos de la persona: " + id);
        }
         
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
    	
    	boolean eliminado = service.eliminarPorId(id);
        if (eliminado) {
            return ResponseEntity.ok("Registro eliminado correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró el registro con ID: " + id);
        }
    }
}
