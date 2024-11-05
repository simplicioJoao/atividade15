package com.example.escola.controller;

import com.example.escola.model.Aluno;
import com.example.escola.model.Curso;
import com.example.escola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @PostMapping("/alunos")
    public Aluno adicionarAluno(@RequestBody Aluno aluno) {
        return escolaService.criarAluno(aluno);
    }

    @PostMapping("/cursos")
    public Curso adicionarCurso(@RequestBody Curso curso) {
        return escolaService.criarCurso(curso);
    }

    @PostMapping("/alunos/{id}/cursos/{cursoId}")
    public Aluno matricularAlunoEmCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        return escolaService.matricularAlunoEmCurso(id, cursoId);
    }

    @DeleteMapping("/alunos/{id}/cursos/{cursoId}")
    public Aluno removerAlunoDeCurso(@PathVariable Long id, @PathVariable Long cursoId) {
        return escolaService.removerAlunoDeCurso(id, cursoId);
    }

    @GetMapping("/alunos/{id}/cursos")
    public List<Curso> listarCursosDeAluno(@PathVariable Long id) {
        return escolaService.listarCursosDeAluno(id);
    }

    @GetMapping("/cursos/{id}/alunos")
    public List<Aluno> listarAlunosDeCurso(@PathVariable Long id) {
        return escolaService.listarAlunosDeCurso(id);
    }
}
