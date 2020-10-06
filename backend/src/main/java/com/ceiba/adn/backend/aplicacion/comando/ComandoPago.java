package com.ceiba.adn.backend.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


public class ComandoPago {

    public  BigDecimal monto;
    public  String estado;
    public  String documento;

    public ComandoPago(BigDecimal monto, String estado, String documento) {
        this.monto = monto;
        this.estado = estado;
        this.documento = documento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public String getEstado() {
        return estado;
    }

    public String getDocumento() {
        return documento;
    }
}
