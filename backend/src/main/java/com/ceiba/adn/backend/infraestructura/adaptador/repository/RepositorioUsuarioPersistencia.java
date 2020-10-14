package com.ceiba.adn.backend.infraestructura.adaptador.repository;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.infraestructura.adaptador.convertidor.UsuarioConvertidor;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoUsuarioJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;

import java.util.Optional;

public class RepositorioUsuarioPersistencia implements RepositorioUsuario {

    private final DaoUsuarioJPA repositorio;

    private final UsuarioConvertidor modelMapper;


    public RepositorioUsuarioPersistencia(DaoUsuarioJPA repositorio, UsuarioConvertidor modelMapper) {
        this.repositorio = repositorio;
        this.modelMapper = modelMapper;
    }

    @Override
    public Usuario agregar(Usuario usuario) {
        return modelMapper.convertirADominio(repositorio.save(modelMapper.convertirAEntidad(usuario)));
    }

    @Override
    public boolean existe(Usuario usuario) {
        return (this.buscarPorDocumento(usuario.documento) == null ? false : true);
    }

    @Override
    public Usuario buscarPorDocumento(String documento) {
        return repositorio.findByDocumento(documento)==null ? null:modelMapper.convertirADominio(repositorio.findByDocumento(documento));

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
        return modelMapper.convertirADominio(usuario);
    }


}
