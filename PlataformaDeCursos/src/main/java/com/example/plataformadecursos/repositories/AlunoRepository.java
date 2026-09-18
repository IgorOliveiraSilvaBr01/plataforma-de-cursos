package com.example.plataformadecursos.repositories;

import com.example.plataformadecursos.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
