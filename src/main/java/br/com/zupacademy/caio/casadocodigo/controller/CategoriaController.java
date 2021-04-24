package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.CategoriaRequest;
import br.com.zupacademy.caio.casadocodigo.exception.CategoriaDuplicadoValidator;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CategoriaController {

    CategoriaRepository categoriaRepository;
    CategoriaDuplicadoValidator categoriaDuplicadoValidator;

    CategoriaController(CategoriaRepository categoriaRepository, CategoriaDuplicadoValidator categoriaDuplicadoValidator) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaDuplicadoValidator = categoriaDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(categoriaDuplicadoValidator);
    }

    @PostMapping("/categoria")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {
        categoriaRepository.save(categoriaRequest.toCategoria());
        return ResponseEntity.ok().body("Uma nova categoria foi cadastrada");
    }
}
