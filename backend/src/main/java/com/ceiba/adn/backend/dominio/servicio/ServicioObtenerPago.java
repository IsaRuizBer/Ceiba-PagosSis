package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.puerto.dao.DaoPago;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class ServicioObtenerPago {

    private final DaoPago respositorio;


    public ServicioObtenerPago(DaoPago respositorio) {
        this.respositorio = respositorio;
    }

    public List<DtoPago> ejecutar() {
        List<DtoPago> lista=respositorio.obtenerPagos();
        return  lista.stream().map(pago-> new DtoPago(pago.monto,pago.estado,pago.documento,this.formatearFecha(pago.fecha))).collect(Collectors.toList());
    }

    public Date formatearFecha(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formato.parse(fecha.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fecha;
    }
}

