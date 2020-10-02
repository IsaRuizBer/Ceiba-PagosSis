package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.puerto.dao.DaoPago;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RepositorioDaoPagoPersistencia implements DaoPago {


    private final DaoPagoJPA repositorio;

    public RepositorioDaoPagoPersistencia(DaoPagoJPA repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<DtoPago> obtenerPagos() {
        return   repositorio.findAll().stream()
                .map(pago -> new DtoPago(pago.getMonto(),pago.getEstado(),pago.getDocumento(), pago.getFecha()))
                .collect(Collectors.toList());

    }


}
