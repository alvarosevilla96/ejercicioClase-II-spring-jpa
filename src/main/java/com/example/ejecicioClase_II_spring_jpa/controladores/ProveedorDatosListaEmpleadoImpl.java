package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Empleado;
import com.example.ejecicioClase_II_spring_jpa.servicios.EmpleadoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaEmpleadoImpl implements ProveedorDatosLista {

    private final EmpleadoSrvc empleadoSrvc;

    public ProveedorDatosListaEmpleadoImpl(EmpleadoSrvc empleadoSrvc) {
        this.empleadoSrvc = empleadoSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Empleados";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("ID", "Nombre", "Apellidos", "Puesto");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Empleado> empleados = empleadoSrvc.listarTodos();
        List<Map<String, Object>> filas = empleados.stream()
                .map(empleado ->{
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", empleado.getId());
                    fila.put("nombre", empleado.getNombre());
                    fila.put("apellidos", empleado.getApellido1() + " " + empleado.getApellido2());
                    fila.put("puesto", empleado.getPuesto());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "empleado";
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
