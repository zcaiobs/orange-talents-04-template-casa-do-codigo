package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.caio.casadocodigo.validator.ExistsValue;
import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {
    @NotBlank @UniqueValue(domainClass = Estado.class, fieldName = "nome")
    private final String nome;
    @NotNull @ExistsValue(domainClass = Pais.class, fieldName = "id")
    private final Long pais;

    public String getNome() {
        return nome;
    }

    public Long getPais() {
        return pais;
    }

    public EstadoRequest(String nome, Long pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public Estado toEstado(PaisRepository paisRepository) {
        System.out.println( pais);
        return new Estado(this.nome, paisRepository.findById(pais).get());
    }
}
