package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import com.ceiba.adn.backend.infraestructura.adaptador.convertidor.PagoConvertidor;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositorioPagoPersistencia implements RepositorioPago {

    private final DaoPagoJPA repositorio;
    @Autowired
    private PagoConvertidor pagoConvertidor;

    public RepositorioPagoPersistencia(DaoPagoJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Pago agregar(Pago pago) {
        return pagoConvertidor.convertirADominio(repositorio.save(pagoConvertidor.convertirAEntidad(pago)));
    }

    @Override
    public boolean existe(Pago pago) {
        return pago!=null;
    }



    @Override
    public boolean buscarPorFecha(String fecha, String documento) {
        String[] splitted = fecha.split("-");
        return this.existe(pagoConvertidor.convertirADominio(repositorio.findByDocumentoAndFecha( Integer.parseInt(splitted[0]),Integer.parseInt(splitted[1]), documento)));
    }
}
