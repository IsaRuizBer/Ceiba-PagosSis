package com.ceiba.adn.backend.infraestructura.adaptador.dao;

import com.ceiba.adn.backend.infraestructura.adaptador.entidad.PagoEntidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoPagoJPA extends CrudRepository<PagoEntidad, Long> {

    public List<PagoEntidad> findAll();
    public PagoEntidad save(PagoEntidad entidad);
    public Optional<PagoEntidad> findById (Long id);
    @Query("select pe from PagoEntidad pe where pe.documento=:documento and MONTH(pe.fecha) = :mes and YEAR(pe.fecha)=:anio")
    public PagoEntidad findByDocumentoAndFecha(@Param("anio") int anio,@Param("mes") int mes,@Param("documento") String documento);
}
