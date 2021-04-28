package br.com.zupacademy.caio.casadocodigo.domain;

import java.math.BigDecimal;

public class LivroDetalhesResponse {

    private final Long id;
    private final String titulo;
    private final String resumo;
    private final String sumario;
    private final BigDecimal preco;
    private final Integer pagina;
    private final String isbn;
    private final CategoriaResponse categoria;
    private final AutorResponse autor;

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getPagina() {
        return pagina;
    }

    public String getIsbn() {
        return isbn;
    }

    public CategoriaResponse getCategoria() {
        return categoria;
    }

    public AutorResponse getAutor() {
        return autor;
    }

    public LivroDetalhesResponse(Long id ,String titulo, String resumo,
                                 String sumario, BigDecimal preco, Integer pagina,
                                 String isbn, CategoriaResponse categoria, AutorResponse autor) {
        this.id = id;
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.pagina = pagina;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
    }

    public static LivroDetalhesResponse converter(Livro livro) {
        var categoria = CategoriaResponse.converter(livro);
        var autor = AutorResponse.converter(livro);

        return new LivroDetalhesResponse(
                livro.getId(), livro.getTitulo(), livro.getResumo(),
                livro.getSumario(), livro.getPreco(), livro.getPagina(),
                livro.getIsbn(), categoria, autor
        );
    }


}
