package com.example.plataformadecursos.repositories;

import com.example.plataformadecursos.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
