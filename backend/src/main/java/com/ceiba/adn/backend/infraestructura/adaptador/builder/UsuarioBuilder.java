package com.ceiba.adn.backend.infraestructura.adaptador.builder;


import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;

public class UsuarioBuilder {


    UsuarioBuilder() {
    }

    public static UsuarioEntidad convertirAEntidad (Usuario dominio){
        return new UsuarioEntidad(dominio.nombre, dominio.apellido,dominio.documento, dominio.correo);
    }

    public static Usuario convertirADominio(UsuarioEntidad entidad){
        Usuario usuario= null;
        if (entidad!=null){
            usuario=new Usuario(entidad.getId(),entidad.getNombre(),entidad.getApellido(),entidad.getDocumento(),entidad.getCorreo());
        }
        return usuario;

    }

}
