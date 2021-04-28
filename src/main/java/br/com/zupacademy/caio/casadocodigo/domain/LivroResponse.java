package br.com.zupacademy.caio.casadocodigo.domain;

import org.springframework.data.domain.Page;

public class LivroResponse {
    private final Long id;
    private final String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LivroResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Page<LivroResponse> converter(Page<Livro> livros) {
        return livros.map(LivroResponse::converter);
    }

    public static LivroResponse converter(Livro livro) {
        return new LivroResponse(livro.getId(), livro.getTitulo());
    }
}
