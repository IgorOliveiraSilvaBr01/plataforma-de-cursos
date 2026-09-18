package com.example.plataformadecursos.services;

import com.example.plataformadecursos.DTOs.AlunoRequest;
import com.example.plataformadecursos.DTOs.AlunoResponse;
import com.example.plataformadecursos.entities.Aluno;
import com.example.plataformadecursos.repositories.AlunoRepository;
import com.example.plataformadecursos.repositories.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final CursoRepository cursoRepository;

    public AlunoService(AlunoRepository alunoRepository, CursoRepository cursoRepository) {
        this.alunoRepository = alunoRepository;
        this.cursoRepository = cursoRepository;
    }

    public String createUser(AlunoRequest request) {
        Aluno aluno = new Aluno(
                request.getNome(),
                request.getEmail()
        );

        alunoRepository.save(aluno);
        return "Aluno criado com sucesso!";
    }

    public List<AlunoResponse> listUsers(){
        return alunoRepository.findAll().stream().map(usuario -> new AlunoResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail()
        )).toList();
    }

    public AlunoResponse findId(Long id){
        Optional<Aluno> aluno = alunoRepository.findById(id);
        AlunoResponse response = new AlunoResponse(aluno);

        return response;
    }

    public String alterUser(Long id, AlunoRequest request){
        Aluno aluno = alunoRepository.findById(id).orElseThrow();
        aluno.setNome(request.getNome());
        aluno.setEmail(request.getEmail());

        alunoRepository.save(aluno);
        return "Dados do aluno alterado com sucesso!";
    }

    public String deleteUser(Long id){
        Optional<Aluno> contato = alunoRepository.findById(id);

        if (contato.isEmpty()) {
            return "Aluno Inexistente!";
        } else {
            alunoRepository.deleteById(id);
            return "Aluno deletado do sistema!";
        }
    }
}
