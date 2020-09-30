package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionValorObligatorio;
import com.ceiba.adn.backend.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PagoTest {

    @Test
    public void validarDocumento(){
        //arrange
        PagoTestDataBuilder builder= new PagoTestDataBuilder();
        //act
        //action
        assertThrows(ExcepcionValorObligatorio.class,()->builder.conDocumento(null).build());
    }
    @Test
    public void validarMonto(){
        //arrange
        PagoTestDataBuilder builder= new PagoTestDataBuilder();
        //act
        //action
        assertThrows(ExcepcionValorObligatorio.class,()->builder.conMonto(null).build());
    }
}
