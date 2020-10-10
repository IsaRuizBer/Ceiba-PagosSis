package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.infraestructura.adaptador.convertidor.UsuarioConvertidor;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoUsuarioJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class RepositorioUsuarioPersistencia implements RepositorioUsuario {

    private final DaoUsuarioJPA repositorio;


    public RepositorioUsuarioPersistencia(DaoUsuarioJPA repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        return UsuarioConvertidor.convertirADominio(repositorio.save(UsuarioConvertidor.convertirAEntidad(usuario)));
    }

    @Override
    public boolean existe(Usuario usuario) {
        return (this.buscarPorDocumento(usuario.documento) == null ? false : true);
    }

    @Override
    public Usuario buscarPorDocumento(String documento) {
        return repositorio.findByDocumento(documento)==null ? null:UsuarioConvertidor.convertirADominio(repositorio.findByDocumento(documento));

    }

    @Override
    public void editar(Usuario usuario) {
        repositorio.update(usuario.nombre, usuario.apellido, usuario.documento, usuario.correo, usuario.id);
    }

    @Override
    public void eliminar(Usuario usuario) {
        UsuarioEntidad entidad = this.repositorio.findByDocumento(usuario.documento);
        this.repositorio.deleteById(entidad.getId());
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Optional<UsuarioEntidad> o= this.repositorio.findById(id);
        if (!o.isPresent()) {
            throw new ExcepcionExisteUsuario("No existe usuario");
        }
        UsuarioEntidad usuario = o.get();
        return UsuarioConvertidor.convertirADominio(usuario);
    }


}
