package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.aplicacion.comando.manejador.ManejadorAgregarPago;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
public class ControladorCrearPago {


    private final ManejadorAgregarPago manejador;


    public ControladorCrearPago(ManejadorAgregarPago manejador) {
        this.manejador = manejador;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoPago comando){
       this.manejador.ejecutar(comando);
    }
}
