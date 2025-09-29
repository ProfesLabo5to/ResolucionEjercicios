package com.example.demo.repository;
import com.example.demo.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadRepository extends JpaRepository<Especialidad, Long> {
    // ya tiene métodos como findAll(), save(), deleteById(), etc.
}
