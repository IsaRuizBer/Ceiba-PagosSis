package com.ceiba.adn.backend.dominio.unitaria;

import com.ceiba.adn.backend.dominio.excepciones.ExcepcionExisteUsuario;
import com.ceiba.adn.backend.dominio.excepciones.ExcepcionPagoRealizado;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;
import com.ceiba.adn.backend.dominio.puerto.repository.RepositorioUsuario;
import com.ceiba.adn.backend.dominio.servicio.ServicioAgregarUsuario;
import com.ceiba.adn.backend.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ServicioAgregarUsuarioTest {

    @Test
    public void validaExisteUsuario(){
        //arrange
        Usuario builder= new UsuarioTestDataBuilder().build();
        RepositorioUsuario repo= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repo.existe(builder)).thenReturn(true);
        Mockito.when(repo.buscarPorDocumento(builder.documento)).thenReturn(builder);
        //act
        ServicioAgregarUsuario servicio = new ServicioAgregarUsuario(repo);
        //assert
        assertThrows(ExcepcionExisteUsuario.class,()->servicio.ejecutar(builder));

    }

    @Test
    public void noExisteUsuario(){

        //arrange
        Usuario builder= new UsuarioTestDataBuilder().build();
        RepositorioUsuario repo= Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repo.existe(builder)).thenReturn(false);
        //act
        ServicioAgregarUsuario servicio = new ServicioAgregarUsuario(repo);
        boolean existe= servicio.existe(builder);
        //assert
        assertFalse(existe);
    }

}
