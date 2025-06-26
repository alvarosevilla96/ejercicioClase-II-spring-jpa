package com.example.ejecicioClase_II_spring_jpa.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "pagos")
public class Pago {
    @SequenceGenerator(name = "pago_id_gen", sequenceName = "empleado_codigo_empleado_seq", allocationSize = 1)
    @EmbeddedId
    private PagoId id;

    @MapsId("codigoCliente")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codigo_cliente", nullable = false)
    private Cliente codigoCliente;

    @Column(name = "forma_pago", nullable = false, length = 40)
    private String formaPago;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "total", nullable = false, precision = 15, scale = 2)
    private BigDecimal total;

}