package com.ceiba.adn.backend.dominio.excepciones;

public class ExcepcionExisteUsuario extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public ExcepcionExisteUsuario(String message) {
        super(message);
    }
}
