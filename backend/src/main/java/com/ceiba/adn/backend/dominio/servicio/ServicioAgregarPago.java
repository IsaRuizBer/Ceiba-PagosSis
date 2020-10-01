package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ServicioAgregarPago {

        private final RepositorioPago repositorioPago;

        public ServicioAgregarPago(RepositorioPago repositorioPago) {
            this.repositorioPago = repositorioPago;
        }

        public Pago ejecutar(Pago pago){
            return repositorioPago.agregar(pago);
        }

        public boolean validaExistencia(Pago pago){
            return repositorioPago.buscarPorFecha(convertToLocalDate(pago.fecha),pago.documento);
        }

    public  String convertToLocalDate(Date dateToConvert) {
         String fecha=dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate().toString();
         return fecha;
    }

}
