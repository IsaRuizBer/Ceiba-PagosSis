package com.ceiba.adn.backend.dominio.modelo.entidad;


import java.math.BigDecimal;

public class Pago  {

    private BigDecimal monto;
    private String estado;
    private String documento;

    public Pago( BigDecimal monto, String estado, String documento) {
        ValidadorArgumento.validarObligatorio(monto,"El monto no puede estar vacío");
        ValidadorArgumento.validarObligatorio(documento,"El documento no puede estar vacío");


        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
    }


    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
