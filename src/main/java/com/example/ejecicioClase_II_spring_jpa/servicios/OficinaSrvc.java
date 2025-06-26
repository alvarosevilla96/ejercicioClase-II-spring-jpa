package com.example.ejecicioClase_II_spring_jpa.servicios;

import com.example.ejecicioClase_II_spring_jpa.DTOs.ClienteDTO;
import com.example.ejecicioClase_II_spring_jpa.entidades.Cliente;
import com.example.ejecicioClase_II_spring_jpa.entidades.Oficina;
import com.example.ejecicioClase_II_spring_jpa.repositorios.ClienteRepo;
import com.example.ejecicioClase_II_spring_jpa.repositorios.OficinaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OficinaSrvc {

    private final OficinaRepo oficinaRepo;

    public OficinaSrvc(OficinaRepo oficinaRepo) {
        this.oficinaRepo = oficinaRepo;
    }

    public List<Oficina> listarTodos(){
        return oficinaRepo.findAll();
    }

    public Optional<Oficina> cargarOficina(String oficinaId) {
        return oficinaRepo.findById(oficinaId);
    }

    public void grabarOficina(Oficina oficina) {
        oficinaRepo.save(oficina);
    }

}
