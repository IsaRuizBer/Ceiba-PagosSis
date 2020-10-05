package com.ceiba.adn.backend.aplicacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class ComandoUsuario {

    public Long id;
    public  String documento;
    public  String nombre;
    public  String apellido;
    public  String correo;

    public ComandoUsuario(Long id, String documento, String nombre, String apellido, String correo) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }
}
