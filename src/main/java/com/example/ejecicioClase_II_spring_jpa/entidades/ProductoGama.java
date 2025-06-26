package com.example.ejecicioClase_II_spring_jpa.entidades;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="productos_gamas")
public class ProductoGama {
    @EmbeddedId
    private ProductoGamaPK id;

    private Integer existencias;
}