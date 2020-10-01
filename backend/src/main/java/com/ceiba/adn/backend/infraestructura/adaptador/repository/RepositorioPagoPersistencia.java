package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import com.ceiba.adn.backend.infraestructura.adaptador.builder.PagoBuilder;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;

import java.util.ArrayList;
import java.util.Date;

public class RepositorioPagoPersistencia implements RepositorioPago {

    private final DaoPagoJPA repositorio;

    public RepositorioPagoPersistencia(DaoPagoJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Pago agregar(Pago pago) {
        return PagoBuilder.convertirADominio(repositorio.save(PagoBuilder.convertirAEntidad(pago)));
    }

    @Override
    public boolean existe(Pago pago) {
        if (pago!=null)
            return true;
        return false;
    }



    @Override
    public boolean buscarPorFecha(String fecha, String documento) {
        String[] splitted = fecha.split("-");
        return this.existe(PagoBuilder.convertirADominio(repositorio.findByDocumentoAndFecha( splitted[0],splitted[1], documento)));
    }
}
