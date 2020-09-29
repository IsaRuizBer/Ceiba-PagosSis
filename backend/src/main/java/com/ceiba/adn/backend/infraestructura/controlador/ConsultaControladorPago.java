package com.ceiba.adn.backend.infraestructura.controlador;


import com.ceiba.adn.backend.aplicacion.consulta.ManejadorObtenerPago;
import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/pagos")
public class ConsultaControladorPago {

    public final ManejadorObtenerPago manejadorObtenerPago;


    public ConsultaControladorPago(ManejadorObtenerPago manejadorObtenerPago) {
        this.manejadorObtenerPago = manejadorObtenerPago;
    }

    @GetMapping("/listar")
    public List<DtoPago> listar(){
    return manejadorObtenerPago.ejecutar();
    }
}
