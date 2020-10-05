package com.ceiba.adn.backend.dominio.excepciones;

public class ExcepcionExisteUsuario extends RuntimeException{
    public ExcepcionExisteUsuario(String message) {
        super(message);
    }
}
