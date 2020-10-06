package com.ceiba.adn.backend.infraestructura.adaptador.dao;


import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaoUsuarioJPA extends CrudRepository<UsuarioEntidad,Long> {

    public UsuarioEntidad save(UsuarioEntidad entidad);
    public UsuarioEntidad findByDocumento(String documento);
    public void delete(UsuarioEntidad entidad);

}
