package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.consulta.ManejadorConsultarUsuario;
import com.ceiba.adn.backend.dominio.modelo.dto.DtoPago;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios/buscar")
public class ConsultaControladorUsuario {

    public final ManejadorConsultarUsuario manejadorConsultarUsuario;

    public ConsultaControladorUsuario(ManejadorConsultarUsuario manejadorConsultarUsuario) {
        this.manejadorConsultarUsuario = manejadorConsultarUsuario;
    }

    @GetMapping("/{documento}")
    public Usuario listar(@PathVariable String documento){
        return manejadorConsultarUsuario.ejecutar(documento);
    }


}
