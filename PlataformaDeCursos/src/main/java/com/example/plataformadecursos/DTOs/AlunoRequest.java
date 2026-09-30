package com.example.plataformadecursos.DTOs;

import com.example.plataformadecursos.entities.Curso;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlunoRequest {

    @NotNull
    private String nome;
    @NotBlank
    @Email
    @Column(length = 150)
    private String email;
}
