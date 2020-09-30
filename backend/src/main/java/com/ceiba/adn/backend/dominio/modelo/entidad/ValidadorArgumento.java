package com.ceiba.adn.backend.dominio.modelo.entidad;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionValorObligatorio;

public class ValidadorArgumento {

    private ValidadorArgumento(){}

    public static void validarObligatorio(Object valor, String mensaje){
        if(valor == null){
            throw new ExcepcionValorObligatorio(mensaje);
        }
    }


}
