package br.com.zupacademy.caio.casadocodigo.domain;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {
    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toCategoria() {
        return new Categoria(this.nome);
    }
}
