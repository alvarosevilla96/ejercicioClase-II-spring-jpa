package com.example.ejecicioClase_II_spring_jpa.controladores;

import java.util.List;
import java.util.Map;

public interface ProveedorDatosLista {

    String getTitulo();

    List<String> getCabeceras();

    List<Map<String, Object>> getFilas();

    String getNombreEntidad();

    Map<String, String> getCabecerasExtendidas();
}
