package com.ceiba.adn.backend.infraestructura.configuracion.servicio;

import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarPago;
import com.ceiba.adn.backend.dominio.servicio.ServicioObtenerPago;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.repository.RepositorioDaoPagoPersistencia;
import com.ceiba.adn.backend.infraestructura.adaptador.repository.RepositorioPagoPersistencia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioObtenerPago servicioObtenerPago(DaoPagoJPA repositorio){
        return new ServicioObtenerPago(new RepositorioDaoPagoPersistencia(repositorio));
    }

    @Bean
    public ServicioAgregarPago servicioAgregarPago(DaoPagoJPA repositorio){
        return new ServicioAgregarPago(new RepositorioPagoPersistencia(repositorio));
    }




}
