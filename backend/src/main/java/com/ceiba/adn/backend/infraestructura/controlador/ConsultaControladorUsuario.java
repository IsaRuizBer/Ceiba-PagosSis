package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.consulta.ManejadorConsultarUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/pagos/usuarios")
public class ConsultaControladorUsuario {

    public final ManejadorConsultarUsuario manejadorConsultarUsuario;

    public ConsultaControladorUsuario(ManejadorConsultarUsuario manejadorConsultarUsuario) {
        this.manejadorConsultarUsuario = manejadorConsultarUsuario;
    }

    @GetMapping("/buscar/{documento}")
    public Usuario listar(@PathVariable(value="documento")  String documento){
        return manejadorConsultarUsuario.ejecutar(documento);
    }


}
