package com.ceiba.adn.backend.dominio.puerto.dao;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;

import java.util.List;

    public interface DaoPago {

        /**
         * Permite obtener los pagos
         * @return
         */
        List<DtoPago> obtenerPagos();
    }
