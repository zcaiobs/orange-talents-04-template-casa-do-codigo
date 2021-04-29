package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank @UniqueValue(domainClass = Pais.class, fieldName = "nome")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Pais toPais() {
        return new Pais(this.nome);
    }
}
