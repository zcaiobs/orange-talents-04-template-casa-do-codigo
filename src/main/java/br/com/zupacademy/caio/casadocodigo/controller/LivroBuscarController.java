package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.LivroDetalhesResponse;
import br.com.zupacademy.caio.casadocodigo.domain.LivroListarResponse;
import br.com.zupacademy.caio.casadocodigo.exception.ExeceptionNotFound;
import br.com.zupacademy.caio.casadocodigo.repository.LivroRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api")
public class LivroBuscarController {

    private final Logger logger = LoggerFactory.getLogger(LivroBuscarController.class);
    private final LivroRepository livroRepository;

    LivroBuscarController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping("/livros")
    @Cacheable(value = "listarLivros")
    public ResponseEntity<Page<LivroListarResponse>> listar(@PageableDefault Pageable pageable) {
        return ResponseEntity.ok().body(LivroListarResponse.converter(livroRepository.findAll(pageable)));
    }

    @GetMapping("/livros/{id}")
    @Cacheable(value = "exibirLivro")
    public ResponseEntity<?> exibirDetalhes(@PathVariable @NumberFormat Long id) throws ExeceptionNotFound {
        var livro = livroRepository.findById(id).orElseThrow(ExeceptionNotFound::new);
        return ResponseEntity.ok().body(LivroDetalhesResponse.converter(livro));
    }
}
