package com.example.ejecicioClase_II_spring_jpa.servicios;

import com.example.ejecicioClase_II_spring_jpa.entidades.Gama;
import com.example.ejecicioClase_II_spring_jpa.repositorios.GamaProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GamaProductoSrvc {

    private final GamaProductoRepo gamaProductoRepo;

    public GamaProductoSrvc(GamaProductoRepo gamaProductoRepo) {
        this.gamaProductoRepo = gamaProductoRepo;
    }

    public List<Gama> listarTodos(){
        return gamaProductoRepo.findAll();
    }
}
