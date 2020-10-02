package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarPago;
import com.ceiba.adn.backend.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ServicioAgregarPagoTest {

    @Test
    public void validarFechaTopeTest(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(java.util.Date.from(LocalDate.parse("2020-09-03").atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .build();
        RepositorioPago repo = Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha("2020-09-03 00:00:00","104235698")).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);

        LocalDate fechaTope=servicio.obtenerFechaTopePago(LocalDate.parse("2020-09-03"));
         boolean esDespues= servicio.validarFechaTope(servicio.convertToLocalDate(pago.fecha), fechaTope);
        //assert
        assertFalse(esDespues);
    }

    @Test
    public void validarExistePago(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(java.util.Date.from(LocalDate.parse("2020-09-03").atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .build();
        RepositorioPago repo= Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha("2020-09-03",pago.documento)).thenReturn(true);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        boolean existe=servicio.validaExistencia(pago);
        //assert
        assertTrue(existe);
    }

    @Test
    public void noExistePago(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(new Date())
                .build();

        RepositorioPago repo= Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha(pago.fecha.toString(),pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        boolean existe=servicio.validaExistencia(pago);
        //assert
        assertFalse(existe);
    }

}
