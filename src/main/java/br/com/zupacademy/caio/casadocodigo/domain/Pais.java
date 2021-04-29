package br.com.zupacademy.caio.casadocodigo.domain;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nome;

    public Pais(String nome) {
        this.nome = nome;
    }

    public Pais() {

    }
}
