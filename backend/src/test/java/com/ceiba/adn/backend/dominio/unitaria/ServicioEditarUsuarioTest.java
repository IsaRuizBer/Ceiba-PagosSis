package com.ceiba.adn.backend.dominio.unitaria;


import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioEditarUsuario;
import com.ceiba.adn.backend.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class ServicioEditarUsuarioTest {


    @Test
    public void validarEditarUsuario(){
        //arrange
        Usuario builder= new UsuarioTestDataBuilder().build();

        RepositorioUsuario repo= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repo.buscarPorDocumento(builder.documento)).thenReturn(builder);
        Usuario builderActualiza= new UsuarioTestDataBuilder()
                .conApellido(builder.apellido)
                .conNombre(builder.nombre)
                .conCorreo("jose.berenal82@correo.com")
                .conDocumento(builder.documento)
                .build();
       // Mockito.when(repo.editar(builderActualiza)).thenReturn(builderActualiza);


        //assert
        assertThat(builderActualiza.correo).isEqualTo("jose.berenal82@correo.com");
    }
}
