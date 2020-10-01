package com.ceiba.adn.backend.infraestructura.adaptador.dao;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.PagoEntidad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DaoPagoJPA extends CrudRepository<PagoEntidad, Long> {

    public List<PagoEntidad> findAll();
    public PagoEntidad save(Pago pago);
    public Optional<PagoEntidad> findById (Long id);

    //@Query("select pe from PagoEntidad where pe.fecha like %?1% and pe.documento=2?")
   // @Query("select pe from PagoEntidad pe where pe.documento=:documento and (DATEPART(yyyy, pe.fecha) = :anio\n" +
    //        "AND    DATEPART(mm, pe.fecha) = :mes )")
    @Query("select EXTRACT(YEAR_MONTH FROM pe.fecha) from PagoEntidad pe where pe.documento=:documento and MONTH(pe.fecha) = :mes and YEAR(pe.fecha)=:anio")
  //  public PagoEntidad findByDocumentoAndFecha(@Param("mes") String mes,@Param("anio") String anio,@Param("documento") String documento);
    public PagoEntidad findByDocumentoAndFecha(@Param("mes") String mes,@Param("anio") String anio,@Param("documento") String documento);
}
