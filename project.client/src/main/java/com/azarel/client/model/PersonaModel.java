package com.azarel.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class PersonaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Long idcliente;
    
    @Column(name = "identificacion", length = 20, nullable = false)
    private String identificacion;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 100, nullable = false)
    private String apellido;
    
    @Column(name = "edad", length = 20)
    private Integer edad;
    
    @Column(name = "direccion", length = 500)
    private String direccion;
    
    @Column(name = "telefono", length = 20)
    private String telefono;

    @Column(name = "estado", length = 20)
    private String estado;

    @JsonProperty("estado_civil")
    @Column(name = "estado_civil", length = 20)
    private String estadoCivil;
}
