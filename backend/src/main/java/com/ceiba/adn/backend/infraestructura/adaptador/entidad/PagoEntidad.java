package com.ceiba.adn.backend.infraestructura.adaptador.entidad;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name="Pago" )
public class PagoEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

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

    public PagoEntidad() {
    }

    public PagoEntidad(BigDecimal monto, String estado, String documento) {
        this.monto = monto;
        this.estado = estado;
        this.documento=documento;
    }


}
