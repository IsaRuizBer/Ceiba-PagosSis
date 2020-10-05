package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;

public class ServicioConsultarUsuario {

    private final RepositorioUsuario repo;
    public ServicioConsultarUsuario(RepositorioUsuario repo) {
        this.repo = repo;
    }

    public Usuario buscar(String documento){
        Usuario result=repo.buscarPorDocumento(documento);
        if (result==null)
            throw new ExcepcionExisteUsuario("No existe el usuario");
      return (repo.buscarPorDocumento(documento));
    }

}
