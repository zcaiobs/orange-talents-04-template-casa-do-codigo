package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.Autor;
import br.com.zupacademy.caio.casadocodigo.domain.AutorRequest;
import br.com.zupacademy.caio.casadocodigo.exception.EmailDuplicadoValidator;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class AutorController {

    private final AutorRepository autorRepository;
    private final EmailDuplicadoValidator emailDuplicadoValidator;

    AutorController(AutorRepository autorRepository, EmailDuplicadoValidator emailDuplicadoValidator) {
        this.autorRepository = autorRepository;
        this.emailDuplicadoValidator = emailDuplicadoValidator;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping("/autor")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AutorRequest request) {
            Autor autor = autorRepository.save(request.toAutor());
            return ResponseEntity.ok(autor.toString());
    }
}
