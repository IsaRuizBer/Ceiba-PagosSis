package com.ceiba.adn.backend.testdatabuilder;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;

import java.math.BigDecimal;
import java.util.Date;

public class PagoDtoTestDataBuilder {

    private BigDecimal monto;
    private String estado;
    private String documento;
    private Date fecha;

    public PagoDtoTestDataBuilder(){
        this.monto= new BigDecimal(850.000);
        this.estado="AL día";
        this.documento="104235698";
        this.fecha= new Date();
    }
    public PagoDtoTestDataBuilder conMonto(BigDecimal monto){
        this.monto= monto;
        return this;
    }

    public PagoDtoTestDataBuilder conEstado(String estado){
        this.estado= estado;
        return this;
    }

    public PagoDtoTestDataBuilder conDocumento(String documento){
        this.documento= documento;
        return this;
    }
    public PagoDtoTestDataBuilder conFecha(Date fecha){
        this.fecha= fecha;
        return this;
    }

    public DtoPago build(){return new DtoPago(monto,estado,documento,fecha);}
}

