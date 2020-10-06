package com.ceiba.adn.backend.aplicacion.consulta;

import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioConsultarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorConsultarUsuario {

    ServicioConsultarUsuario servicio;

    public ManejadorConsultarUsuario(ServicioConsultarUsuario servicio) {
        this.servicio = servicio;
    }

    public Usuario ejecutar(String documento){ return this.servicio.buscar(documento);}
}
