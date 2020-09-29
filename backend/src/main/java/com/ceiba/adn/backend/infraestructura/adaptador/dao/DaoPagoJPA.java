package com.ceiba.adn.backend.infraestructura.adaptador.dao;

import com.ceiba.adn.backend.dominio.modelo.entidad.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaoPagoJPA extends JpaRepository<Pago, Long>  {

    public List<Pago> findAll();
    public Pago save(Pago pago);
    public Pago getOne (Long id);
}
