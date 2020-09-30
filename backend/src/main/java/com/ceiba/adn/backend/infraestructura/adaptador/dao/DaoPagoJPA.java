package com.ceiba.adn.backend.infraestructura.adaptador.dao;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.PagoEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoPagoJPA extends CrudRepository<PagoEntidad, Long> {

    public List<PagoEntidad> findAll();
    public PagoEntidad save(Pago pago);
    public PagoEntidad getOne (Long id);
}
