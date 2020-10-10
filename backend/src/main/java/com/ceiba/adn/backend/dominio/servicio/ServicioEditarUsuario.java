package com.ceiba.adn.backend.dominio.servicio;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;

import java.sql.SQLException;
import java.text.ParseException;


public class ServicioEditarUsuario {

    private final RepositorioUsuario repo;

    public ServicioEditarUsuario(RepositorioUsuario repo) {
        this.repo = repo;
    }


    public void ejecutar(Usuario usuario, String documento)  throws SQLException {
       // Usuario result=repo.buscarPorDocumento(documento);

        if (repo.buscarPorDocumento(documento)==null)
            throw new ExcepcionExisteUsuario("No existe el usuario");

         repo.editar(usuario);
    }
}
