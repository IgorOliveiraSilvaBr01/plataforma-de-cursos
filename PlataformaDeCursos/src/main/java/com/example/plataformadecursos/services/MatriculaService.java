package com.example.plataformadecursos.services;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.entities.Aluno;
import com.example.plataformadecursos.entities.Curso;
import com.example.plataformadecursos.repositories.AlunoRepository;
import com.example.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class MatriculaService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public MatriculaService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String matricula(long idAluno, long idMatricula) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();

        Curso curso = cursoRepository.getReferenceById(idMatricula);
        aluno.getCursos().add(curso);

        alunoRepository.save(aluno);

        return "Aluno matriculado";
    }

    public String alterarMatricula(long idAluno, long idMatricula) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();

        Curso cursoAntigo = cursoRepository.getReferenceById(idMatricula);
        Curso cursoNovo = cursoRepository.getReferenceById(idMatricula);

        aluno.getCursos().remove(cursoAntigo);
        aluno.getCursos().remove(cursoNovo);

        alunoRepository.save(aluno);

        return "Matricula alterada!";
    }

    public String deletarMatricula(long idAluno, long idMatricula) {
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow();

        Curso curso = cursoRepository.getReferenceById(idMatricula);
        aluno.getCursos().remove(curso);

        alunoRepository.save(aluno);

        return "Aluno removido do curso!";
    }
}
