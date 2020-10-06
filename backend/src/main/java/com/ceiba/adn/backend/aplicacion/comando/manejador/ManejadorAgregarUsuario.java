package com.ceiba.adn.backend.aplicacion.comando.manejador;


import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.aplicacion.comando.fabrica.FabricaUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorAgregarUsuario {

    public FabricaUsuario fabrica;
    public  ServicioAgregarUsuario servicio;

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
