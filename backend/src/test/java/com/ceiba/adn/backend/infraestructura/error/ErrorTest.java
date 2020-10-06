package com.ceiba.adn.backend.infraestructura.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorTest {

    @Test
    public void errorTest() {
        Error error = new Error("ErrorTest", "Error descripcion");
        assertEquals("ErrorTest", error.getNombreExcepcion());
    }
}
