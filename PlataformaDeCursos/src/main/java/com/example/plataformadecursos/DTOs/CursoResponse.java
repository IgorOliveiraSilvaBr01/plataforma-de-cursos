package com.example.plataformadecursos.DTOs;

import com.example.plataformadecursos.entities.Aluno;
import com.example.plataformadecursos.entities.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResponse {

    private long id;
    private String nome;
    private String cargaHoraria;
    private List<String> alunosList = new ArrayList();

    public CursoResponse(long id, String nome, String cargaHoraria) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public CursoResponse(Optional<Curso> curso) {
        id = curso.get().getId();
        nome = curso.get().getNome();
        cargaHoraria = curso.get().getCargaHoraria();
    }

    public void addAluno(String aluno) {
        this.alunosList.add(aluno);
    }
}
