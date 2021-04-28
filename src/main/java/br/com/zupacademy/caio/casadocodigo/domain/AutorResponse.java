package br.com.zupacademy.caio.casadocodigo.domain;

public class AutorResponse {

    private final Long id;
    private final String nome;
    private final String descricao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public AutorResponse(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public static AutorResponse converter(Livro livro) {
        return new AutorResponse(
                livro.getAutor().getId(),
                livro.getAutor().getNome(),
                livro.getAutor().getDescricao()
        );
    }
}
