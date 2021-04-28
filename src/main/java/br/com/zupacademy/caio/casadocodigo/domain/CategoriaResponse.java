package br.com.zupacademy.caio.casadocodigo.domain;

public class CategoriaResponse {

    private final String nome;

    public String getNome() {
        return nome;
    }

    public CategoriaResponse(String nome) {
        this.nome = nome;
    }

    public static CategoriaResponse converter(Livro livro) {
        return new CategoriaResponse(livro.getCategoria().getNome());
    }
}
