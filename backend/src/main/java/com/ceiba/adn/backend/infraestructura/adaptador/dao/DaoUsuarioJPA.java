package com.ceiba.adn.backend.infraestructura.adaptador.dao;


import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface DaoUsuarioJPA extends CrudRepository<UsuarioEntidad, Long> {

    public UsuarioEntidad save(UsuarioEntidad entidad);
    public UsuarioEntidad findByDocumento(String documento);
    public void delete(UsuarioEntidad entidad);
    public Optional<UsuarioEntidad> findById(Long id);
    @Modifying
    @Transactional
    @Query("update UsuarioEntidad ue set ue.nombre=:nombre, ue.apellido=:apellido, ue.documento=:documento, ue.correo=:correo where ue.id=:id")
    public void update(@Param("nombre") String nombre,@Param("apellido") String apellido,@Param("documento") String documento,@Param("correo") String correo,@Param("id") Long id);

}
