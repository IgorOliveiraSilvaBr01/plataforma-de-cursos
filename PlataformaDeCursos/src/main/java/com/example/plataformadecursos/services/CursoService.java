package com.example.plataformadecursos.services;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.DTOs.AlunoResponse;
import com.example.plataformadecursos.DTOs.CursoRequest;
import com.example.plataformadecursos.DTOs.CursoResponse;
import com.example.plataformadecursos.entities.Aluno;
import com.example.plataformadecursos.entities.Curso;
import com.example.plataformadecursos.repositories.AlunoRepository;
import com.example.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public CursoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String createCourse(CursoRequest request) {
        Curso curso = new Curso(
                request.getNome(),
                request.getCargaHoraria()
        );

        cursoRepository.save(curso);
        return "Curso criado com sucesso!";
    }

    public List<CursoResponse> listCourses() {
        List<CursoResponse> list = new ArrayList();
        List<Curso> cursos = cursoRepository.findAll();


        for (Curso curso: cursos) {
            CursoResponse response = new CursoResponse();
            response.setId(curso.getId());
            response.setNome(curso.getNome());
            response.setCargaHoraria(curso.getCargaHoraria());
            for (Aluno aluno : curso.getAlunos()){
                response.addAluno(aluno.getNome());
            }
            list.add(response);
        }

        return list;
    }

    public CursoResponse findIdCourse(Long id) {
        CursoResponse response = new CursoResponse();
        Curso curso = cursoRepository.findById(id).orElseThrow();

        response.setId(curso.getId());
        response.setNome(curso.getNome());
        response.setCargaHoraria(curso.getCargaHoraria());
        for (Aluno aluno : curso.getAlunos()) {
            response.addAluno(curso.getNome());
        }

        return response;
    }

    public String alterCourse(Long id, CursoRequest request){
        Curso curso = cursoRepository.findById(id).orElseThrow();
        curso.setNome(request.getNome());
        curso.setCargaHoraria(request.getCargaHoraria());

        cursoRepository.save(curso);
        return "Dados do curso alterado com sucesso!";
    }

    public String deleteCourse(Long id){
        Optional<Curso> curso = cursoRepository.findById(id);

        if (curso.isEmpty()) {
            return "Curso Inexistente!";
        } else {
            cursoRepository.deleteById(id);
            return "Curso deletado do sistema!";
        }
    }
}

