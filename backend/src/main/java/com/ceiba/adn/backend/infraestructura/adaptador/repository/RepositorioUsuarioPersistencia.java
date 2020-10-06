package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.infraestructura.adaptador.builder.UsuarioBuilder;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoUsuarioJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;

import java.util.Optional;

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
        return (this.buscarPorDocumento(usuario.documento)==null?false:true);
    }

    @Override
    public Usuario buscarPorDocumento(String documento) {
        return UsuarioBuilder.convertirADominio(repositorio.findByDocumento(documento));
    }

    @Override
    public Usuario editar(Usuario usuario) {
       return UsuarioBuilder.convertirADominio(repositorio.save(UsuarioBuilder.convertirAEntidad(usuario)));
    }

    @Override
    public void eliminar(Usuario usuario) {
        this.repositorio.deleteById(usuario.id);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<UsuarioEntidad> o= this.repositorio.findById(id);
        if (!o.isPresent()) {
            throw new ExcepcionExisteUsuario("No existe usuario");
        }
        UsuarioEntidad usuario = o.get();
        return UsuarioBuilder.convertirADominio(usuario);
    }

}
