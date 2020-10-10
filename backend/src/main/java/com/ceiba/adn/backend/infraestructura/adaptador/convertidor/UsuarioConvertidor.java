package com.ceiba.adn.backend.infraestructura.adaptador.convertidor;


import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;

public class UsuarioConvertidor {



    public static UsuarioEntidad convertirAEntidad (Usuario dominio){
        return new UsuarioEntidad(dominio.nombre, dominio.apellido,dominio.documento, dominio.correo);
    }

    public static Usuario convertirADominio(UsuarioEntidad entidad){
        return new Usuario(entidad.getId(),entidad.getNombre(),entidad.getApellido(),entidad.getDocumento(),entidad.getCorreo());

    }

}
