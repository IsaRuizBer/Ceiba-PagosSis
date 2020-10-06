package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.consulta.ManejadorConsultarUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pagos/usuarios/")
public class ConsultaControladorUsuario {

    public final ManejadorConsultarUsuario manejadorConsultarUsuario;

    public ConsultaControladorUsuario(ManejadorConsultarUsuario manejadorConsultarUsuario) {
        this.manejadorConsultarUsuario = manejadorConsultarUsuario;
    }

    @GetMapping("/buscar/{documento}")
    public Usuario listar(@PathVariable("documento")  String documento){
        return manejadorConsultarUsuario.ejecutar(documento);
    }


}
