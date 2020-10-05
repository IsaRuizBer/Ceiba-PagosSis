package com.ceiba.adn.backend.aplicacion.comando.manejador;

import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.aplicacion.comando.fabrica.FabricaUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioEditarUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEditarUsuario {

    private static FabricaUsuario fabrica;
    private static ServicioEditarUsuario servicio;

    public ManejadorEditarUsuario(FabricaUsuario fabrica,ServicioEditarUsuario servicio) {
        this.fabrica=fabrica;
        this.servicio=servicio;
    }

    public void  ejecutar(ComandoUsuario usuario, String documento){
        Usuario objeto= this.fabrica.buscar(usuario);
        this.servicio.ejecutar(objeto,documento);
    }

}
