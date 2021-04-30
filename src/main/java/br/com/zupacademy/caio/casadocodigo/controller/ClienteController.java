package br.com.zupacademy.caio.casadocodigo.controller;

import br.com.zupacademy.caio.casadocodigo.domain.ClienteRequest;
import br.com.zupacademy.caio.casadocodigo.domain.ClienteResponse;
import br.com.zupacademy.caio.casadocodigo.exception.ExceptionResponse;
import br.com.zupacademy.caio.casadocodigo.repository.ClienteRepository;
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
public class ClienteController {

    private final ClienteRepository clienteRepository;
    private final PaisRepository paisRepository;
    private final EstadoRepository estadoRepository;

    ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @PostMapping("/clientes")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {
        var pais = paisRepository.findById(clienteRequest.getPais()).get();
        var estados = estadoRepository.findAllByPais(pais);

        if (estados.isEmpty() && clienteRequest.getEstado() == null){
          var cliente = clienteRepository.save(clienteRequest.toCliente(pais));
          return ResponseEntity.ok(ClienteResponse.converter(cliente));
        }

        var estado = estadoRepository.findByIdAndPais(clienteRequest.getEstado(), pais);
        if (estado.isPresent()) {
            var cliente = clienteRepository.save(clienteRequest.toCliente(pais, estado.get()));
            return ResponseEntity.ok(ClienteResponse.converter(cliente));
        }

        return ResponseEntity.badRequest()
                .body(new ExceptionResponse("estado", "Valor não encontrado."));
    }
}
