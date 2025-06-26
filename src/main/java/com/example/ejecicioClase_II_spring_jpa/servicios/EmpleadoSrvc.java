package com.example.ejecicioClase_II_spring_jpa.servicios;

import com.example.ejecicioClase_II_spring_jpa.entidades.Empleado;
import com.example.ejecicioClase_II_spring_jpa.repositorios.EmpleadoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoSrvc {

    private final EmpleadoRepo empleadoRepo;

    public EmpleadoSrvc(EmpleadoRepo empleadoRepo) {
        this.empleadoRepo = empleadoRepo;
    }

    public List<Empleado> listarTodos(){
        return empleadoRepo.findAll();
    }
}
