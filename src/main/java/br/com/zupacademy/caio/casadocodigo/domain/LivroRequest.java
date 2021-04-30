package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.DateFutureValue;
import br.com.zupacademy.caio.casadocodigo.validator.ExistsValue;
import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class LivroRequest {

    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
    private final String titulo;
    @NotBlank @Size(max = 500)
    private final String resumo;
    private final String sumario;
    @NotNull @DecimalMin(value = "20.0")
    private final BigDecimal preco;
    @NotNull @Min(100)
    private final Integer pagina;
    @NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
    private final String isbn;
    @DateFutureValue(fieldName = "publicacao")
    private final Date publicacao;
    @NotNull @ExistsValue(domainClass = Categoria.class, fieldName = "id")
    private final Long categoriaId;
    @NotNull @ExistsValue(domainClass = Autor.class, fieldName = "id")
    private final Long autorId;

    public LivroRequest(String titulo, String resumo, String sumario,
                        BigDecimal preco, Integer pagina, String isbn,
                        Date publicacao, Long categoriaId, Long autorId) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.pagina = pagina;
        this.isbn = isbn;
        this.publicacao = publicacao;
        this.categoriaId = categoriaId;
        this.autorId = autorId;
    }

    public Livro toLivro(Categoria categoria, Autor autor) {
        return new Livro(this.titulo, this.resumo, this.sumario,
                this.preco, this.pagina, this.isbn, this.publicacao,
                categoria, autor);
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public Long getAutorId() {
        return autorId;
    }
}
