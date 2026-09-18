package com.example.plataformadecursos.DTOs;

import com.example.plataformadecursos.entities.Aluno;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoRequest {

    @NotNull
    private String nome;
    @NotNull @NotBlank
    @Column(length = 4)
    private String cargaHoraria;
    private Set<Aluno> Curso;
}
