package com.ceiba.adn.backend.aplicacion.comando.manejador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoPago;
import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.aplicacion.comando.fabrica.FabricaUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioEditarUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarUsuario {

    private static FabricaUsuario fabrica;
    private static ServicioAgregarUsuario servicio;

    public ManejadorAgregarUsuario(FabricaUsuario fabrica,
                                   ServicioAgregarUsuario servicio) {
        this.fabrica=fabrica;
        this.servicio=servicio;

    }

    public void ejecutar (ComandoUsuario comando){
        Usuario usuario=this.fabrica.agregar(comando);
        this.servicio.ejecutar(usuario);
    }


}
