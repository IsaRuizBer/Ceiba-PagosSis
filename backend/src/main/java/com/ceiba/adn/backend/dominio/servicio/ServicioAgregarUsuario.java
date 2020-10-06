package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;


public class ServicioAgregarUsuario {

    private final RepositorioUsuario repo;

    public ServicioAgregarUsuario(RepositorioUsuario repo) {
        this.repo = repo;
    }

    public Usuario ejecutar(Usuario usuario){
        if (existe(usuario))
            throw  new ExcepcionExisteUsuario("El usuario ya existe");
        return repo.agregar(usuario);
    }

    public boolean existe(Usuario usuario){
       return(repo.existe(usuario));
    }
}
