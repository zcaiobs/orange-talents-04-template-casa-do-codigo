package br.com.zupacademy.caio.casadocodigo.domain;

import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String documento; // cfp ou cnpj
    private String endereco;
    private String complemento;
    private String cidade;
    private String telefone;
    private String cep;
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado; // se o país tiver


    public Long getId() {
        return id;
    }

    public Cliente(String nome, String sobrenome, String email,
                   String documento, String endereco, String complemento,
                   String cidade, String telefone, String cep,
                   Pais pais, Estado estado) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente() {

    }
}
