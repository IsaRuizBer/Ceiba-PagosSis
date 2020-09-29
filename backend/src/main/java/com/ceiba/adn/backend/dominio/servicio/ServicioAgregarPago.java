package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import org.springframework.stereotype.Component;

public class ServicioAgregarPago {

        private final RepositorioPago repositorioPago;

        public ServicioAgregarPago(RepositorioPago repositorioPago) {
            this.repositorioPago = repositorioPago;
        }

        public Pago ejecutar(Pago pago){
            return repositorioPago.agregar(pago);
        }

        public boolean existePago(Pago pago){
            return this.repositorioPago.existe(pago);
        }

}
