package br.com.zupacademy.caio.casadocodigo.domain;

import br.com.zupacademy.caio.casadocodigo.validator.ExistsValue;
import br.com.zupacademy.caio.casadocodigo.validator.CPFouCNPJ;
import br.com.zupacademy.caio.casadocodigo.validator.UniqueValue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteRequest {

    @NotBlank
    private final String nome;
    @NotBlank
    private final String sobrenome;
    @NotBlank @Email
    @UniqueValue(domainClass = Cliente.class, fieldName = "email")
    private final String email;
    @CPFouCNPJ
    @NotBlank @UniqueValue(domainClass = Cliente.class, fieldName = "documento")
    private final String documento; // cfp ou cnpj
    @NotBlank
    private final String endereco;
    @NotBlank
    private final String complemento;
    @NotBlank
    private final String cidade;
    @NotNull @ExistsValue(domainClass = Pais.class, fieldName = "id")
    private final Long pais;
    private final Long estado;
    @NotBlank
    private final String telefone;
    @NotBlank
    private final String cep;


    public ClienteRequest(
            String nome, String sobrenome, String email,
            String documento, String endereco, String complemento,
            String cidade, Long pais, Long estado,
            String telefone, String cep) {
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

    public Cliente toCliente(Pais pais) {
        return new Cliente(
                this.nome, this.sobrenome, this.email,
                this.documento, this.endereco,
                this.complemento, this.cidade,
                this.telefone, this.cep,
                pais, null
        );
    }

    public Cliente toCliente(Pais pais, Estado estado) {
        return new Cliente(
                this.nome, this.sobrenome, this.email,
                this.documento, this.endereco,
                this.complemento, this.cidade,
                this.telefone, this.cep,
                pais, estado
        );
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public String getDocumento() {
        return documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public Long getPais() {
        return pais;
    }

    public Long getEstado() {
        return estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }
}
