package com.azarel.client.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteModel extends PersonaModel{



    @Column(name = "users", nullable = false, length = 50)
    private String users;

    @Column(name = "pass", nullable = false, length = 50)
    private String pass;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;
    
    @JsonProperty("tipo_cliente")
    @Column(name = "tipo_cliente")
    private String tipoCliente;


    @Column(name = "estado", length = 50)
    private String estado;

}
