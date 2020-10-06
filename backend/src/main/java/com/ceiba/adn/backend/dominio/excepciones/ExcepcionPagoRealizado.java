package com.ceiba.adn.backend.dominio.excepciones;

public class ExcepcionPagoRealizado extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionPagoRealizado(String message) {
        super(message);
    }
}
