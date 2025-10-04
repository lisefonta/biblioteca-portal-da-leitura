package com.portal.leitura.controller;

import com.portal.leitura.model.Livro;
import com.portal.leitura.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = "*")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/cadastrar")
    public Livro cadastrar(@RequestParam String titulo, @RequestParam String autor) {
        Livro livro = new Livro(titulo, autor);
        return repository.save(livro);
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    @PostMapping("/{id}/emprestar")
    public String emprestar(@PathVariable Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        if (livro.isEmprestado()) {
            return "Livro já está emprestado!";
        }
        livro.emprestar();
        repository.save(livro);
        return "Livro emprestado com sucesso!";
    }

    @PostMapping("/{id}/devolver")
    public String devolver(@PathVariable Long id) {
        Livro livro = repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        if (!livro.isEmprestado()) {
            return "Livro não estava emprestado!";
        }
        livro.devolver();
        repository.save(livro);
        return "Livro devolvido com sucesso!";
    }
}
