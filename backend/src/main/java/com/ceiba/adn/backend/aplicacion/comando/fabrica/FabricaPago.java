package com.ceiba.adn.backend.aplicacion.comando.fabrica;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import org.springframework.stereotype.Component;

@Component
public class FabricaPago {

    public Pago agregar(ComandoPago comando){
        return new Pago(comando.monto,comando.estado, comando.documento );
    }
}
