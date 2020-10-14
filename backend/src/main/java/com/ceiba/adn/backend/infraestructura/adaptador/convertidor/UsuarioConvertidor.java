package com.ceiba.adn.backend.infraestructura.adaptador.convertidor;


import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.infraestructura.adaptador.entidad.UsuarioEntidad;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConvertidor {

    private ModelMapper modelMapper = new ModelMapper();

    public  UsuarioEntidad convertirAEntidad (Usuario dominio){
      //  return new UsuarioEntidad(dominio.nombre, dominio.apellido,dominio.documento, dominio.correo);
        return modelMapper.map(dominio, UsuarioEntidad.class);
    }

    public  Usuario convertirADominio(UsuarioEntidad entidad){
       // return new Usuario(entidad.getId(),entidad.getNombre(),entidad.getApellido(),entidad.getDocumento(),entidad.getCorreo());
        return modelMapper.map(entidad, Usuario.class);

    }

}
