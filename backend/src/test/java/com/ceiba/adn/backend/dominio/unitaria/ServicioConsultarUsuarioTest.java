package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioConsultarUsuario;
import com.ceiba.adn.backend.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioConsultarUsuarioTest {

    @Test
    public void existeUsuario(){
        //arrange
        Usuario builder= new UsuarioTestDataBuilder().build();
        RepositorioUsuario repo= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repo.buscarPorDocumento(builder.documento)).thenReturn(builder);
        //act
        ServicioConsultarUsuario servicio= new ServicioConsultarUsuario(repo);
        Usuario usuario=repo.buscarPorDocumento(builder.documento);
        //assert
        //assert
        assertThat("jose.bernal@correo.com").isEqualTo(usuario.correo);

    }

    @Test
    public void validarEliminarUsuario(){
        //arrange
        Usuario builder= new UsuarioTestDataBuilder().build();
        RepositorioUsuario repo= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repo.buscarPorDocumento(builder.documento)).thenReturn(null);
        repo.eliminar(builder);
        //act
        ServicioConsultarUsuario servicio= new ServicioConsultarUsuario(repo);
        //assert
        assertThrows(ExcepcionExisteUsuario.class,()->servicio.buscar(builder.documento));
    }

}
