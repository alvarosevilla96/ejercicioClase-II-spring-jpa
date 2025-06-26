package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.entidades.Oficina;
import com.example.ejecicioClase_II_spring_jpa.entidades.Producto;
import com.example.ejecicioClase_II_spring_jpa.servicios.ProductoSrvc;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProveedorDatosListaProductoImpl implements ProveedorDatosLista {

    private final ProductoSrvc productoSrvc;

    public ProveedorDatosListaProductoImpl(ProductoSrvc productoSrvc) {
        this.productoSrvc = productoSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Productos";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("Codigo", "Nombre", "Cantidad", "Precio", "Descripción");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<Producto> productos = productoSrvc.listarTodos();
        List<Map<String, Object>> filas = productos.stream()
                .map(pro ->{
                    Map<String, Object> fila = new LinkedHashMap<>();
                    fila.put("id", pro.getCodigoProducto());
                    fila.put("nombre", pro.getNombre());
                    fila.put("cantidadEnStock", pro.getCantidadEnStock());
                    fila.put("precioVenta", pro.getPrecioVenta());
                    fila.put("descripcion", pro.getDescripcion());
                    return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "producto";
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
