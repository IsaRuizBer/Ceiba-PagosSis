package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRealizado;
import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRetrasado;
import com.ceiba.adn.backend.dominio.excepciones.ExcepcionValorObligatorio;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class ServicioAgregarPagoTest {

    @Test
    public void validarFechaTope(){
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

        //assert
        assertThrows(ExcepcionPagoRealizado.class,()->servicio.ejecutar(pago));

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


    @Test
    public void obtenerFechaPago(){
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
        Mockito.when(repo.buscarPorFecha(pago.fecha.toString(),pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        LocalDate fechaTopePago=servicio.obtenerFechaPago(pago.fecha);
        //assert
        assertNotNull(fechaTopePago);

    }

    @Test
    public void validarFechaNoEsFinDeSemana(){
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
        Mockito.when(repo.buscarPorFecha(pago.fecha.toString(),pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        LocalDate fecha_=servicio.convertToLocalDate(pago.fecha);
       boolean bandera=servicio.validarFinDeSemana(fecha_);
        //assert
        assertFalse(bandera);
    }

    @Test
    public void validarFechaEsFinDeSemana(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(java.util.Date.from(LocalDate.parse("2020-09-05").atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .build();

        RepositorioPago repo= Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha(pago.fecha.toString(),pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        LocalDate fecha_=servicio.convertToLocalDate(pago.fecha);
        boolean bandera=servicio.validarFinDeSemana(fecha_);
        //assert
        assertTrue(bandera);
    }

    @Test
    public void obtenerFechaPagoFinDeSermana(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(java.util.Date.from(LocalDate.parse("2020-09-05").atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()))
                .build();

        RepositorioPago repo= Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha(pago.fecha.toString(),pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        LocalDate fecha=servicio.convertToLocalDate(pago.fecha);
        LocalDate fechaTopePago=servicio.obtenerFechaPago(pago.fecha);
        //assert
        assertThat(fechaTopePago).isEqualTo(fecha.plusDays(2));

    }


    @Test
    public void validaRetrasoEnPago(){
        //arrange
        Pago pago = new PagoTestDataBuilder()
                .conDocumento("104235698")
                .conMonto(new BigDecimal(850000))
                .conEstado("Al día")
                .conFecha(java.util.Date.from(LocalDate.now().withDayOfMonth(1)
                        .plusDays(10)
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant())
                        ).build();
        RepositorioPago repo= Mockito.mock(RepositorioPago.class);
        Mockito.when(repo.buscarPorFecha("",pago.documento)).thenReturn(false);
        //act
        ServicioAgregarPago servicio= new ServicioAgregarPago(repo);
        //assert
        assertThrows(ExcepcionPagoRetrasado.class,()->servicio.ejecutar(pago));
    }




}
