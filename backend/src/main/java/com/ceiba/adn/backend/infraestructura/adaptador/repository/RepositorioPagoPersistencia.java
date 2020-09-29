package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioPago;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;

public class RepositorioPagoPersistencia implements RepositorioPago {

    private final DaoPagoJPA repositorio;

    public RepositorioPagoPersistencia(DaoPagoJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Pago agregar(Pago pago) {
        return repositorio.save(pago);
    }

    @Override
    public boolean existe(Pago pago) {
        return false;
    }
}
