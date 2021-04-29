package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.EstadoRequest;
import br.com.zupacademy.caio.casadocodigo.domain.PaisRequest;
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
public class PaisEstadoController {

    PaisRepository paisRepository;
    EstadoRepository estadoRepository;

    PaisEstadoController(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }


    @PostMapping("/paises")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {
        paisRepository.save(paisRequest.toPais());
        return ResponseEntity.ok().build();
    }

    @PostMapping("/estados")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {
        estadoRepository.save(estadoRequest.toEstado(paisRepository));
        return ResponseEntity.ok().build();
    }
}
