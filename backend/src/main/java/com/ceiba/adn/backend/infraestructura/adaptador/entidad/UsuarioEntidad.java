package com.ceiba.adn.backend.infraestructura.adaptador.entidad;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="usuario" )
public class UsuarioEntidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "documento", nullable = false)
    private String documento;
    @Column(name = "correo", nullable = false)
    private String correo;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad( String nombre, String apellido, String documento, String correo) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
