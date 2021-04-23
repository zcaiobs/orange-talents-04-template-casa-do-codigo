package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.AutorRequest;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AutorController {

    private final AutorRepository autorRepository;

    AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/autor")
    public ResponseEntity<String> cadastrar(@RequestBody @Valid AutorRequest request) {
        autorRepository.save(request.toAutor());
        return ResponseEntity.ok("Um novo autor foi criado");
    }
}
