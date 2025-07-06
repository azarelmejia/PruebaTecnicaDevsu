package com.azarel.client.model;

import java.time.LocalDateTime;

public class ErrorRespuesta {
    private LocalDateTime datehr;
    private String msg;
    private String resultado;

    public ErrorRespuesta(String msg, String resultado) {
        this.datehr = LocalDateTime.now();
        this.msg = msg;
        this.resultado = resultado;
    }

    // getters y setters
}

