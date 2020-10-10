package com.ceiba.adn.backend.infraestructura.adaptador.convertidor;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.PagoEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PagoConvertidor {

    private ModelMapper modelMapper = new ModelMapper();

    private PagoConvertidor(){

    }

    public  Pago convertirADominio(PagoEntidad entidad){
        return modelMapper.map(entidad, Pago.class);
    }

    public PagoEntidad convertirAEntidad (Pago dominio){
        return modelMapper.map(dominio, PagoEntidad.class);
    }

    public static DtoPago convertirADto(PagoEntidad entidad ){

        return new DtoPago(entidad.getMonto(),entidad.getEstado(),entidad.getDocumento(), entidad.getFecha());
    }

}
