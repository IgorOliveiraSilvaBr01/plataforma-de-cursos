package com.example.plataformadecursos.DTOs;


import com.example.plataformadecursos.entities.Aluno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoResponse {

    private long id;
    private String nome;
    private String email;

    public AlunoResponse(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public AlunoResponse(Optional<Aluno> aluno){
        id = aluno.get().getId();
        nome = aluno.get().getNome();
        email = aluno.get().getEmail();
    }
}
