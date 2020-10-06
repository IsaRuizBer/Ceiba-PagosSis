package com.ceiba.adn.backend.aplicacion.comando.fabrica;

import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class FabricaUsuario {
    public Usuario agregar(ComandoUsuario comando){
        return new Usuario(comando.id,comando.nombre,comando.apellido, comando.documento, comando.correo );
    }

    public Usuario buscar(ComandoUsuario comando){
        return new Usuario(comando.id,comando.nombre,comando.apellido, comando.documento, comando.correo );
    }
}
