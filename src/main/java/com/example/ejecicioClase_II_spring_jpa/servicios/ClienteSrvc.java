package com.example.ejecicioClase_II_spring_jpa.servicios;

import com.example.ejecicioClase_II_spring_jpa.DTOs.ClienteDTO;
import com.example.ejecicioClase_II_spring_jpa.entidades.Cliente;
import com.example.ejecicioClase_II_spring_jpa.repositorios.ClienteRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteSrvc {

    private final ClienteRepo clienteRepo;

    public ClienteSrvc(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public List<ClienteDTO> listarTodos(){
        return clienteRepo.findAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }



    public ClienteDTO toDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getCiudad(),
                cliente.getCodigoPostal()
        );
    }
}
