package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Este nome já existe.")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
}
