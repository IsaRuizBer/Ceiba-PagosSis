package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.infraestructura.adaptador.builder.UsuarioBuilder;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoUsuarioJPA;

public class RepositorioUsuarioPersistencia implements RepositorioUsuario {

    private final DaoUsuarioJPA repositorio;

    public RepositorioUsuarioPersistencia(DaoUsuarioJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        return UsuarioBuilder.convertirADominio(repositorio.save(UsuarioBuilder.convertirAEntidad(usuario)));
    }

    @Override
    public boolean existe(Usuario usuario) {
        if (this.buscarPorDocumento(usuario.documento)==null)
            return false;
        return true;
    }

    @Override
    public Usuario buscarPorDocumento(String documento) {
        return UsuarioBuilder.convertirADominio(repositorio.findByDocumento(documento));
    }

    @Override
    public Usuario editar(Usuario usuario) {
        return this.agregar(usuario);
    }

    @Override
    public void eliminar(Usuario usuario) {
        this.repositorio.deleteById(usuario.id);
    }
}
