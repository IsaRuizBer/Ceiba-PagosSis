package com.ceiba.adn.backend.infraestructura.adaptador.entidad;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="Pago" )
public class PagoEntidad implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "monto", nullable = false)
    public BigDecimal monto;
    @Column(name = "estado", nullable = false)
    public String estado;
    @Column(name = "documento", nullable = false)
    public String documento;
    @Column(name = "fecha", nullable = false)
    public Date fecha;

    public PagoEntidad() {
    }

    public PagoEntidad(BigDecimal monto, String estado, String documento, Date fecha) {
        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
        this.fecha= fecha;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
