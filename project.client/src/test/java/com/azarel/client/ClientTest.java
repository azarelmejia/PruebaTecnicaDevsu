package com.azarel.client;

import org.junit.jupiter.api.Test;

import com.azarel.client.model.ClienteModel;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

public class ClientTest {
	
	@Test
    public void testClienteModelGettersAndSetters() {
        ClienteModel cliente = new ClienteModel();
     // Atributos de ClienteModel
        cliente.setUsers("usuario123");
        cliente.setPass("password123");
        cliente.setFechaRegistro(LocalDateTime.now());
        cliente.setTipoCliente("VIP");
        cliente.setEstado("activo");

        // Atributos heredados de PersonaModel
        cliente.setIdcliente(1L);
        cliente.setIdentificacion("0801199901234");
        cliente.setNombre("Juan");
        cliente.setApellido("Pérez");
        cliente.setEdad(30);
        cliente.setDireccion("Av. Principal 123");
        cliente.setTelefono("9999-9999");
        cliente.setEstadoCivil("Soltero");

        // Verificar ClienteModel
        assertEquals("usuario123", cliente.getUsers());
        assertEquals("password123", cliente.getPass());
        assertNotNull(cliente.getFechaRegistro());
        assertEquals("VIP", cliente.getTipoCliente());
        assertEquals("activo", cliente.getEstado());

        // Verificar PersonaModel (heredado)
        assertEquals(1L, cliente.getIdcliente());
        assertEquals("0801199901234", cliente.getIdentificacion());
        assertEquals("Juan", cliente.getNombre());
        assertEquals("Pérez", cliente.getApellido());
        assertEquals(30, cliente.getEdad());
        assertEquals("Av. Principal 123", cliente.getDireccion());
        assertEquals("9999-9999", cliente.getTelefono());
        assertEquals("Soltero", cliente.getEstadoCivil());
    }

}
