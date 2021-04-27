package br.com.zupacademy.caio.casadocodigo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String resumo;
    private String sumario;
    private BigDecimal preco;
    private Integer pagina;
    @Column(unique = true)
    private String isbn;
    private Date publicacao;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario,
                 BigDecimal preco, Integer pagina, String isbn,
                 Date publicacao, Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.pagina = pagina;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    public Livro() {
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", sumario='" + sumario + '\'' +
                ", preco=" + preco +
                ", pagina=" + pagina +
                ", isbn='" + isbn + '\'' +
                ", publicacao=" + publicacao +
                ", categoria=" + categoria +
                ", autor=" + autor +
                '}';
    }
}
