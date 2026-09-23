package com.example.plataformadecursos.controllers;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.DTOs.AlunoResponse;
import com.example.plataformadecursos.DTOs.CursoRequest;
import com.example.plataformadecursos.DTOs.CursoResponse;
import com.example.plataformadecursos.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<?> saveCourse(@RequestBody CursoRequest request){
        return ResponseEntity.ok(cursoService.createCourse(request));
    }

    @GetMapping
    public ResponseEntity<List<CursoResponse>> listCourses(){
        return ResponseEntity.ok(cursoService.listCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoResponse> findId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cursoService.findId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> alterCourse(@Valid @PathVariable("id") Long id,
                                       @RequestBody CursoRequest request) {
        return ResponseEntity.ok(cursoService.alterCourse(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cursoService.deleteCourse(id));
    }
}
