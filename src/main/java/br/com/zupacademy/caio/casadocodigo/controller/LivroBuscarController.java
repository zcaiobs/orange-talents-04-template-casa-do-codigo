package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.LivroResponse;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LivroBuscarController {

    private final LivroRepository livroRepository;

    LivroBuscarController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    @Cacheable(value = "listarLivros")
    public ResponseEntity<Page<LivroResponse>> listar(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok().body(LivroResponse.converter(livroRepository.findAll(pageable)));
    }
}
