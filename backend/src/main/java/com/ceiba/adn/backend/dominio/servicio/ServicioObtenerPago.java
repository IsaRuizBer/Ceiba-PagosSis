package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.puerto.dao.DaoPago;


import java.util.List;


public class ServicioObtenerPago {

    private final DaoPago respositorio;


    public ServicioObtenerPago(DaoPago respositorio) {
        this.respositorio = respositorio;
    }

    public List<DtoPago> ejecutar() {
        return  respositorio.obtenerPagos();
    }
}
