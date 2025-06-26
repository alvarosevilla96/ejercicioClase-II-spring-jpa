package com.example.ejecicioClase_II_spring_jpa.DTOs;

public record ClienteDTO(
        Integer id,
        String nombreCliente,
        String telefono,
        String ciudad,
        String codigoPostal
) {}
