package com.example.ejecicioClase_II_spring_jpa.entidades;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gamas")
public class Gama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "gama", unique = true, nullable = false)
    private String gama;

    @Column(name = "descripcion_texto", length = Integer.MAX_VALUE)
    private String descripcionTexto;

    @Column(name = "descripcion_html", length = Integer.MAX_VALUE)
    private String descripcionHtml;

    @Column(name = "imagen", length = 256)
    private String imagen;

    @ManyToMany(mappedBy ="gamas")
    private Set<Producto> productos = new LinkedHashSet<>();

}