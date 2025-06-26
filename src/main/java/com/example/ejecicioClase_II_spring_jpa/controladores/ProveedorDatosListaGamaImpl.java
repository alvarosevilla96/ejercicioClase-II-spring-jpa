package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Gama;
import com.example.ejecicioClase_II_spring_jpa.servicios.GamaProductoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaGamaImpl implements ProveedorDatosLista {

    private final GamaProductoSrvc gamaProductoSrvc;

    public ProveedorDatosListaGamaImpl(GamaProductoSrvc gamaProductoSrvc) {
        this.gamaProductoSrvc = gamaProductoSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Gamas";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Gama", "Descripción");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Gama> gamas = gamaProductoSrvc.listarTodos();
        List<Map<String, Object>> filas = gamas.stream()
                .map(gama ->{
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("gama", gama.getGama());
                    fila.put("descripcionTexto", gama.getDescripcionTexto());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "gama";
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
