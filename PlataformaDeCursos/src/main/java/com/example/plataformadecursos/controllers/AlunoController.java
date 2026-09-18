package com.example.plataformadecursos.controllers;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.DTOs.AlunoResponse;
import com.example.plataformadecursos.services.AlunoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aluno")
public class AlunoController {
    private final AlunoService alunoService;
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody AlunoRequest request){
        return ResponseEntity.ok(alunoService.createUser(request));
    }

    @GetMapping
    public ResponseEntity<List<AlunoResponse>> listUsers(){
        return ResponseEntity.ok(alunoService.listUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoResponse> findId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alunoService.findId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterUser(@Valid @PathVariable("id") Long id,
                                       @RequestBody AlunoRequest request) {
        return ResponseEntity.ok(alunoService.alterUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        return ResponseEntity.ok(alunoService.deleteUser(id));
    }
}
