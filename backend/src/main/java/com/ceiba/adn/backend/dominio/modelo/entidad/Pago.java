package com.ceiba.adn.backend.dominio.modelo.entidad;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="Pago" )
public class Pago implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "monto", nullable = false)
    private BigDecimal monto;
    @Column(name = "estado", nullable = false)
    private String estado;
    @Column(name = "documento", nullable = false)
    private String documento;


    public Pago(){

    }

    public Pago( BigDecimal monto, String estado, String documento) {

        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
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
}
