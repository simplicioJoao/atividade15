package com.example.escola.service;

import com.example.escola.model.Aluno;
import com.example.escola.model.Curso;
import com.example.escola.repository.AlunoRepository;
import com.example.escola.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Aluno criarAluno(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public Curso criarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Aluno matricularAlunoEmCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().add(curso);
        return alunoRepository.save(aluno);
    }

    public Aluno removerAlunoDeCurso(Long alunoId, Long cursoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        aluno.getCursos().remove(curso);
        return alunoRepository.save(aluno);
    }

    public List<Curso> listarCursosDeAluno(Long alunoId) {
        Aluno aluno = alunoRepository.findById(alunoId).orElseThrow();
        return List.copyOf(aluno.getCursos());
    }

    public List<Aluno> listarAlunosDeCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId).orElseThrow();
        return List.copyOf(curso.getAlunos());
    }
}
