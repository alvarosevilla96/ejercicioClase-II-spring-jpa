package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Empleado;
import com.example.ejecicioClase_II_spring_jpa.entidades.Oficina;
import com.example.ejecicioClase_II_spring_jpa.servicios.OficinaSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaOficinaImpl implements ProveedorDatosLista {

    private final OficinaSrvc ofiSrvc;

    public ProveedorDatosListaOficinaImpl(OficinaSrvc ofiSrvc) {
        this.ofiSrvc = ofiSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Oficinas";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("ID", "Ciudad", "Telefono");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Oficina> oficinas = ofiSrvc.listarTodos();
        if (oficinas.size() > 3) {
            Oficina ofi1 = oficinas.get(3);
            System.out.println(ofi1.getEmpleados());
        } else {
            System.out.println("No hay suficientes oficinas para acceder al índice 3");
        }
        List<Map<String, Object>> filas = oficinas.stream()
                .map(ofi -> {
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", ofi.getCodigoOficina());
                    fila.put("ciudad", ofi.getCiudad());
                    fila.put("telefono", ofi.getTelefono());
                    // preparo la lista de empleados
                    List<String> datosExtendidos = ofi.getEmpleados().stream()
                            .map(Empleado::toListaExtendida).toList();
                    fila.put("datosExtendidos", datosExtendidos);
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "oficina";
    }
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of("id","Id", "nombre","Nombre", "apellidos","Apellidos", "puesto","Puesto");
    }
}
