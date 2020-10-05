package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionValorObligatorio;
import com.ceiba.adn.backend.testdatabuilder.PagoTestDataBuilder;
import com.ceiba.adn.backend.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class UsuarioTest {

    @Test
    public void validarDocumento(){
        //arrange
        UsuarioTestDataBuilder builder= new UsuarioTestDataBuilder();
        //act
        //action
        assertThrows(ExcepcionValorObligatorio.class,()->builder.conDocumento(null).build());
    }
    @Test
    public void validarMonto(){
        //arrange
        UsuarioTestDataBuilder builder= new UsuarioTestDataBuilder();
        //act
        //action
        assertThrows(ExcepcionValorObligatorio.class,()->builder.conNombre(null).build());
    }
}
