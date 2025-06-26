package com.example.ejecicioClase_II_spring_jpa.repositorios;

import com.example.ejecicioClase_II_spring_jpa.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
