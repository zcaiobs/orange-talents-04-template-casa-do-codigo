package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.EstadoRequest;
import br.com.zupacademy.caio.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.caio.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EstadoController {

    PaisRepository paisRepository;
    EstadoRepository estadoRepository;

    EstadoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping("/estados")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
        var pais = paisRepository.findById(estadoRequest.getPais()).get();
        estadoRepository.save(estadoRequest.toEstado(pais));
        return ResponseEntity.ok().build();
    }
}
