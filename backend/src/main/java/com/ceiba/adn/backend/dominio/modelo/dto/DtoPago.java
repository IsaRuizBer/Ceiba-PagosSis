package com.ceiba.adn.backend.dominio.modelo.dto;

import java.math.BigDecimal;
import lombok.Getter;

    @Getter
    public class DtoPago {

        public BigDecimal monto;
        public String estado;
        public String documento;

        public DtoPago(BigDecimal monto, String estado, String documento) {
            this.monto = monto;
            this.estado = estado;
            this.documento = documento;
        }
    }

