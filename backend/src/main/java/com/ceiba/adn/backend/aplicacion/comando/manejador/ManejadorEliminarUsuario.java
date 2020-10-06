package com.ceiba.adn.backend.aplicacion.comando.manejador;

import com.ceiba.adn.backend.aplicacion.comando.fabrica.FabricaUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarUsuario {

    public FabricaUsuario fabrica;
    public  ServicioEliminarUsuario servicio;


    public ManejadorEliminarUsuario(FabricaUsuario fabrica, ServicioEliminarUsuario servicio ) {
        this.fabrica=fabrica;
        this.servicio=servicio;
    }

    public void ejecutar( String documento){
        this.servicio.eliminar(documento);
    }
}
