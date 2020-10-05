package com.ceiba.adn.backend.dominio.modelo.entidad;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Usuario {
    public Long id;
    public String documento;
    public String nombre;
    public String apellido;
    public String correo;

    public Usuario(Long id,String nombre, String apellido, String documento, String correo) {
        ValidadorArgumento.validarObligatorio(nombre,"El nombre es obligatorio");
        ValidadorArgumento.validarObligatorio(apellido,"El apellido es obligatorio");
        ValidadorArgumento.validarObligatorio(documento,"El documento es obligatorio");
        ValidadorArgumento.validarObligatorio(correo,"El correo es obligatorio");
        this.id = id;
        this.documento= documento;
        this.nombre= nombre;
        this.apellido= apellido;
        this.correo= correo;
    }
}
