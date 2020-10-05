package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private final RepositorioUsuario repo;

    public ServicioEliminarUsuario(RepositorioUsuario repo) {
        this.repo = repo;

    }

    public void eliminar(String documento){
        Usuario result= repo.buscarPorDocumento(documento);
        if (result==null)
            throw new ExcepcionExisteUsuario("No existe el usuario");
        repo.eliminar(result);
    }
}
