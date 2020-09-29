package com.ceiba.adn.backend.aplicacion.consulta;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.servicio.ServicioObtenerPago;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorObtenerPago {

    ServicioObtenerPago servicioObtenerPago;

    public ManejadorObtenerPago(ServicioObtenerPago servicioObtenerPago) {
        this.servicioObtenerPago = servicioObtenerPago;
    }

    public List<DtoPago> ejecutar() {
        return this.servicioObtenerPago.ejecutar();
    }
}
