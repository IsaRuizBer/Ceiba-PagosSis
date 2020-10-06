package com.ceiba.adn.backend.dominio.modelo.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;

    @Getter
    public class DtoPago {

        public BigDecimal monto;
        public String estado;
        public String documento;
        public Date fecha;

        public DtoPago(BigDecimal monto, String estado, String documento, Date fecha) {
            this.monto = monto;
            this.estado = estado;
            this.documento = documento;
            this.fecha=fecha;
        }
    }

