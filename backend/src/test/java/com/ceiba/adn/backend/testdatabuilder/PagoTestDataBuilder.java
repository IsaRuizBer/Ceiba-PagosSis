package com.ceiba.adn.backend.testdatabuilder;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;

import java.math.BigDecimal;
import java.util.Date;

public class PagoTestDataBuilder {

    public BigDecimal monto;
    public String estado;
    public String documento;
    public Date fecha;

    public PagoTestDataBuilder(){
        this.monto= new BigDecimal(850.000);
        this.estado="AL día";
        this.documento="104235698";
        this.fecha= new Date();
    }
    public PagoTestDataBuilder conMonto(BigDecimal monto){
        this.monto= monto;
        return this;
    }

    public PagoTestDataBuilder conEstado(String estado){
        this.estado= estado;
        return this;
    }

    public PagoTestDataBuilder conDocumento(String documento){
        this.documento= documento;
        return this;
    }

    public PagoTestDataBuilder conFecha(Date fecha){
        this.fecha= fecha;
        return this;
    }

    public Pago build(){return new Pago(monto,estado,documento, fecha);}

    public ComandoPago buildComando() {return new ComandoPago(monto,estado,documento);}
}

