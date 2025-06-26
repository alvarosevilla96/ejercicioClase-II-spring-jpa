package com.example.ejecicioClase_II_spring_jpa.repositorios;

import com.example.ejecicioClase_II_spring_jpa.entidades.Oficina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OficinaRepo extends JpaRepository<Oficina, String> {
}
