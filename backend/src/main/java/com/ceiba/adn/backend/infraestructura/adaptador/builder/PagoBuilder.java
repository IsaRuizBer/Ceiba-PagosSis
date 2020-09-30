package com.ceiba.adn.backend.infraestructura.adaptador.builder;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.PagoEntidad;

public class PagoBuilder {

    private PagoBuilder(){

    }

    public static Pago convertirADominio(PagoEntidad entidad){
        Pago pago= null;
        if (entidad!=null){
            pago=new Pago(entidad.getMonto(),entidad.getEstado(),entidad.getDocumento());
        }
        return pago;

    }

    public static PagoEntidad convertirAEntidad (Pago dominio){
        PagoEntidad entidad= new PagoEntidad(dominio.getMonto(), dominio.getEstado(),dominio.getDocumento());
        return entidad;
    }

    public static DtoPago convertirADto(PagoEntidad entidad ){
        DtoPago dto= new DtoPago(entidad.getMonto(),entidad.getEstado(), entidad.getDocumento());
        return dto;
    }

}
