package com.ceiba.adn.backend.dominio.puerto.repository;


import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;

public interface RepositorioUsuario {

    /**
     * Permite crear un usuario
     * @param usuario
     */
    Usuario agregar(Usuario usuario);

    /**
     * Permite determinar si ya existe un usuario
     * @param usuario
     * @return si existe o no
     */
    boolean existe(Usuario usuario);
    /**
     * Permite buscar un usuario por el documento
     * @param documento
     * @return si existe o no
     */
    Usuario buscarPorDocumento(String documento);
    /**
     * Permite editar un usuario
     * @param usuario
     *
     */
    Usuario editar(Usuario usuario);

    /**
     * Permite eliminar un usuario
     * @param usuario
     *
     */
    void eliminar(Usuario usuario);


    Usuario buscarPorId(Long id);
}
