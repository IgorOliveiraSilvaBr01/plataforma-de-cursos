package com.example.plataformadecursos.DTOs;

import com.example.plataformadecursos.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponse {

    private long id;
    private String nome;
    private String cargaHoraria;
    private Set<Aluno> Curso;

    public CursoResponse(String nome, String cargaHoraria, Set<Aluno> curso) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        Curso = curso;
    }
}
