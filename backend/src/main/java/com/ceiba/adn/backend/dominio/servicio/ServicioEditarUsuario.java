package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;

public class ServicioEditarUsuario {

    private final RepositorioUsuario repo;

    public ServicioEditarUsuario(RepositorioUsuario repo) {
        this.repo = repo;
    }


    public Usuario ejecutar(Usuario usuario, String documento){
        if (repo.buscarPorDocumento(documento)==null)
            throw new ExcepcionExisteUsuario("No existe el usuario");

        return repo.editar(usuario);
    }
}
