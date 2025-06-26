package com.example.ejecicioClase_II_spring_jpa.servicios;

import com.example.ejecicioClase_II_spring_jpa.entidades.Producto;
import com.example.ejecicioClase_II_spring_jpa.repositorios.ProductoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoSrvc {

    private final ProductoRepo productoRepo;

    public ProductoSrvc(ProductoRepo productoRepo) {
        this.productoRepo = productoRepo;
    }

    public List<Producto> listarTodos(){
        return productoRepo.findAll();
    }
}
