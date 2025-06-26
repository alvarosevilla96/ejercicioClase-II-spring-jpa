package com.example.ejecicioClase_II_spring_jpa.controladores;

import com.example.ejecicioClase_II_spring_jpa.DTOs.ClienteDTO;
import com.example.ejecicioClase_II_spring_jpa.entidades.Cliente;
import com.example.ejecicioClase_II_spring_jpa.servicios.ClienteSrvc;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProveedorDatosListaClienteImpl implements ProveedorDatosLista{
    private final ClienteSrvc clienteSrvc;

    public ProveedorDatosListaClienteImpl(ClienteSrvc clienteSrvc) {
        this.clienteSrvc = clienteSrvc;
    }

    @Override
    public String getTitulo() {
        return "Lista de Clientes";
    }

    @Override
    public List<String> getCabeceras() {
        return List.of("ID", "Nombre", "Telefono", "Ciudad", "C. Postal");
    }

    @Override
    public List<Map<String, Object>> getFilas() {
        List<ClienteDTO> clientes = clienteSrvc.listarTodos();
        List<Map<String, Object>> filas = clientes.stream()
                .map(cli ->{
                        Map<String, Object> fila = new LinkedHashMap<>();
                        fila.put("id", cli.id());
                        fila.put("nombreCliente", cli.nombreCliente());
                        fila.put("telefono", cli.telefono());
                        fila.put("ciudad", cli.ciudad());
                        fila.put("codigoPostal", cli.codigoPostal());
                        return fila;
                }).toList();
        return filas;
    }

    @Override
    public String getNombreEntidad() {
        return "cliente";
    }

    @Override
    public Map<String, String> getCabecerasExtendidas() {
        return Map.of();
    }
}
