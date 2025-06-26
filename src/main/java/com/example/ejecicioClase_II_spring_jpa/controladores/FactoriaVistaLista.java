package com.example.ejecicioClase_II_spring_jpa.controladores;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class FactoriaVistaLista {

    private final Map<String, ProveedorDatosLista> mapProveedorLista;

    public FactoriaVistaLista(List<ProveedorDatosLista> proveedorDatosParaLista) {
        this.mapProveedorLista = proveedorDatosParaLista.stream()
                .collect(Collectors.toMap(ProveedorDatosLista::getNombreEntidad, Function.identity()));
    }

    public Optional<ProveedorDatosLista> getProveedorDatosLista(String nombreEntidad) {
        return Optional.ofNullable(mapProveedorLista.get(nombreEntidad));
    }
}
