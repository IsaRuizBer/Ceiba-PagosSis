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
        Usuario result=repo.buscarPorDocumento(documento);

        if (result==null)
            throw new ExcepcionExisteUsuario("No existe el usuario");

        Usuario actualiza= repo.buscarPorId(result.id);
        actualiza.setNombre(usuario.nombre);
        actualiza.setApellido(usuario.apellido);
        actualiza.setCorreo(usuario.correo);
        actualiza.setDocumento(usuario.documento);
        actualiza.setId(usuario.id);
        return repo.editar(actualiza);
    }
}
