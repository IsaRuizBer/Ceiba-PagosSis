package com.ceiba.adn.backend.testdatabuilder;

import com.ceiba.adn.backend.aplicacion.comando.ComandoUsuario;
import com.ceiba.adn.backend.dominio.modelo.entidad.Usuario;

import java.math.BigDecimal;

public class UsuarioTestDataBuilder {

    public Long id;
    public String nombre;
    public String apellido;
    public String documento;
    public String correo;

    public UsuarioTestDataBuilder() {
        this.id=new Long(1);
        this.nombre = "José";
        this.apellido = "Bernal";
        this.documento = "125874963";
        this.correo = "jose.bernal@correo.com";
    }


    public UsuarioTestDataBuilder conNombre(String nombre){
        this.nombre= nombre;
        return this;
    }

    public UsuarioTestDataBuilder conApellido(String apellido){
        this.apellido= apellido;
        return this;
    }

    public UsuarioTestDataBuilder conDocumento(String documento){
        this.documento= documento;
        return this;
    }

    public UsuarioTestDataBuilder conCorreo(String correo){
        this.correo= correo;
        return this;
    }


    public Usuario build(){return new Usuario(nombre,apellido,documento,correo);}
    public ComandoUsuario buildComando() {
        return new ComandoUsuario(this.documento, this.nombre,this.apellido,this.correo);
    }

}
