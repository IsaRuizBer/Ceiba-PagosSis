package com.ceiba.adn.backend.dominio.puerto.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;

public interface RepositorioPago {
    /**
     * Permite crear las el pago
     * @param pago
     */
    Pago agregar(Pago pago);

    /**
     * Permite determinar si previamente se registro el pago
     * @param pago
     * @return si existe o no
     */
    boolean existe(Pago pago);
}
