package com.ceiba.adn.backend.infraestructura.configuracion.servicio;

import com.ceiba.adn.backend.dominio.servicio.*;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoPagoJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.dao.DaoUsuarioJPA;
import com.ceiba.adn.backend.infraestructura.adaptador.repository.RepositorioDaoPagoPersistencia;
import com.ceiba.adn.backend.infraestructura.adaptador.repository.RepositorioPagoPersistencia;
import com.ceiba.adn.backend.infraestructura.adaptador.repository.RepositorioUsuarioPersistencia;
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

    @Bean
    public ServicioAgregarUsuario servicioAgregarUsuario(DaoUsuarioJPA repositorio){
        return new ServicioAgregarUsuario(new RepositorioUsuarioPersistencia(repositorio));
    }

    @Bean
    public ServicioEditarUsuario servicioEditarUsuario(DaoUsuarioJPA repositorio){
        return new ServicioEditarUsuario(new RepositorioUsuarioPersistencia(repositorio));
    }
    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(DaoUsuarioJPA repositorio){
        return new ServicioEliminarUsuario(new RepositorioUsuarioPersistencia(repositorio));
    }
    @Bean
    public ServicioConsultarUsuario servicioConsultarUsuario(DaoUsuarioJPA repositorio){
        return new ServicioConsultarUsuario(new RepositorioUsuarioPersistencia(repositorio));
    }

}
