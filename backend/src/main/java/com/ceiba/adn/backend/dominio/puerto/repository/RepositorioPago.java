package com.ceiba.adn.backend.dominio.puerto.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;

import java.util.Date;

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

    /**
     * Permite validar si ya existe un pago en el mes
     * @param fecha y documento
     * @return pago
     */
    boolean buscarPorFecha(String fecha, String documento);
}
