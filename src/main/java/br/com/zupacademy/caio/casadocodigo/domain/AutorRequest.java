package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private final String nome;
    @NotBlank @Email @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Este email já existe.")
    private final String email;
    @NotBlank @Size(max = 400)
    private final String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
