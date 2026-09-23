package com.example.plataformadecursos.DTOs;


import com.example.plataformadecursos.entities.Aluno;
import com.example.plataformadecursos.entities.Curso;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse {

    private long id;
    private String nome;
    private String email;
    private List<String> cursosList = new ArrayList();

    public AlunoResponse(Optional<Aluno> aluno){
        id = aluno.get().getId();
        nome = aluno.get().getNome();
        email = aluno.get().getEmail();
    }

    public void addCategoria(String categoria) {
        this.cursosList.add(categoria);
    }
}
