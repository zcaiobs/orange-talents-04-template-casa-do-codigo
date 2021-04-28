package br.com.zupacademy.caio.casadocodigo.domain;

import org.springframework.data.domain.Page;

public class LivroListarResponse {

    private final Long id;
    private final String nome;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LivroListarResponse(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Page<LivroListarResponse> converter(Page<Livro> livros) {
        return livros.map(LivroListarResponse::converter);
    }

    public static LivroListarResponse converter(Livro livro) {
        return new LivroListarResponse(livro.getId(), livro.getTitulo());
    }
}
