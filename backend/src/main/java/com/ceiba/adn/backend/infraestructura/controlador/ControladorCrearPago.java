package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.aplicacion.comando.manejador.ManejadorAgregarPago;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagos")
public class ControladorCrearPago {


    private final ManejadorAgregarPago manejador;


    public ControladorCrearPago(ManejadorAgregarPago manejador) {
        this.manejador = manejador;
    }

    @CrossOrigin
    @PostMapping
    public void agregar(@RequestBody ComandoPago comando){
       this.manejador.ejecutar(comando);
    }
}
