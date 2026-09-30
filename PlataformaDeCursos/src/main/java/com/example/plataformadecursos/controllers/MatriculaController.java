package com.example.plataformadecursos.controllers;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.services.AlunoService;
import com.example.plataformadecursos.services.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;
    private final AlunoService alunoService;

    public MatriculaController(MatriculaService matriculaService, AlunoService alunoService) {
        this.matriculaService = matriculaService;
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> saveMatricula(@RequestParam long idAluno, @RequestParam long idCurso) {
        return ResponseEntity.ok(matriculaService.matricula(idAluno,idCurso));
    }

    @PutMapping
    public ResponseEntity<?> alterMatricula(@RequestParam long idAluno, @RequestParam long idCurso) {
        return ResponseEntity.ok(matriculaService.alterarMatricula(idAluno, idCurso));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteMatricula(@RequestParam long idAluno, @RequestParam long idCurso) {
        return ResponseEntity.ok(matriculaService.deletarMatricula(idAluno, idCurso));
    }
}
