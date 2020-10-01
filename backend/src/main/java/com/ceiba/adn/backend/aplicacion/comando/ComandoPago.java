package com.ceiba.adn.backend.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPago {

    public BigDecimal monto;
    public String estado;
    public String documento;


}
