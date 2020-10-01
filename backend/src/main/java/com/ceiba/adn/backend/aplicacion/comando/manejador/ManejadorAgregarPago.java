package com.ceiba.adn.backend.aplicacion.comando.manejador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.aplicacion.comando.fabrica.FabricaPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarPago {

    private final ServicioAgregarPago servicio;
    private final FabricaPago fabrica;

    public ManejadorAgregarPago(ServicioAgregarPago servicio, FabricaPago fabrica) {
        this.servicio = servicio;
        this.fabrica = fabrica;
    }

    public void ejecutar (ComandoPago comando){
        Pago pago=this.fabrica.agregar(comando);
        this.servicio.ejecutar(pago);
    }
}
