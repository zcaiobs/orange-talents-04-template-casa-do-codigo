package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Este email já existe.")
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor toAutor() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
