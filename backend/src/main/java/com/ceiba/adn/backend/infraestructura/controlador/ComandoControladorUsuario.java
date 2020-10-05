package com.ceiba.adn.backend.infraestructura.controlador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.aplicacion.comando.manejador.ManejadorAgregarUsuario;
import com.ceiba.adn.backend.aplicacion.comando.manejador.ManejadorEditarUsuario;
import com.ceiba.adn.backend.aplicacion.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class ComandoControladorUsuario {

    public final ManejadorAgregarUsuario manejador;
    public final ManejadorEditarUsuario manejadorEditarUsuario;
    public final ManejadorEliminarUsuario manejadorEliminarUsuario;


    public ComandoControladorUsuario(ManejadorAgregarUsuario manejador, ManejadorEditarUsuario manejadorEditarUsuario, ManejadorEliminarUsuario manejadorEliminarUsuario) {
        this.manejador = manejador;
        this.manejadorEditarUsuario = manejadorEditarUsuario;
        this.manejadorEliminarUsuario = manejadorEliminarUsuario;
    }

    @PostMapping
    public void agregar(@RequestBody ComandoUsuario comando){
        this.manejador.ejecutar(comando);
    }

    @DeleteMapping("/{documento}")
    public void eliminar( @PathVariable("documento") String documento){
        this.manejadorEliminarUsuario.ejecutar(documento);
    }

    @PutMapping(value = "/{documento}")
    public void editar( @PathVariable("documento") String documento, @RequestBody ComandoUsuario comando){
        this.manejadorEditarUsuario.ejecutar(comando, documento);
    }
}
