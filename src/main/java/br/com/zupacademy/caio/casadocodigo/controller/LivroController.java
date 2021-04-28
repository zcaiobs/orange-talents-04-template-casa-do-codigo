package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.LivroRequest;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class LivroController {

    private final LivroRepository livroRepository;
    private final AutorRepository autorRepository;
    private final CategoriaRepository categoriaRepository;

    LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/livros")
    @CacheEvict(value = {"listarLivros", "exibirLivro"}, allEntries = true)
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {
        livroRepository.save(livroRequest.toLivro(categoriaRepository, autorRepository));
        return ResponseEntity.ok().build();
    }
}
