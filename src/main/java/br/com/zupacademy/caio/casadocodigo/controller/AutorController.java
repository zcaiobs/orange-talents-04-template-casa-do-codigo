package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.Autor;
import br.com.zupacademy.caio.casadocodigo.domain.AutorRequest;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AutorController {

    private final AutorRepository autorRepository;

    AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/autores")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorRequest request) {
            autorRepository.save(request.toAutor());
            return ResponseEntity.ok().build();
    }
}
