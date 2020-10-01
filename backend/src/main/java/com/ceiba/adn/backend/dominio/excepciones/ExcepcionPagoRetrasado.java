package com.ceiba.adn.backend.dominio.excepciones;

public class ExcepcionPagoRetrasado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionPagoRetrasado(String message) {
        super(message);
    }
}
