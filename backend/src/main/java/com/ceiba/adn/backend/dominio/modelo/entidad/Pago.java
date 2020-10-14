package com.ceiba.adn.backend.dominio.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Pago  {

    public  BigDecimal monto;
    public  String estado;
    public  String documento;
    public  Date fecha;

    public Pago(){}

    public Pago( BigDecimal monto, String estado, String documento, Date fecha) {
        ValidadorArgumento.validarObligatorio(monto,"El monto no puede estar vacío");
        ValidadorArgumento.validarObligatorio(documento,"El documento no puede estar vacío");
        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
        this.fecha=fecha;
    }

    public Pago( BigDecimal monto, String estado, String documento) {
        ValidadorArgumento.validarObligatorio(monto,"El monto no puede estar vacío");
        ValidadorArgumento.validarObligatorio(documento,"El documento no puede estar vacío");
        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
        this.fecha= new Date();
    }

}
