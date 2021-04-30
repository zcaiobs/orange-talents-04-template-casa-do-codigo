package br.com.zupacademy.caio.casadocodigo.domain;

public class ClienteResponse {

    private final Long id;

    public Long getId() {
        return id;
    }

    public ClienteResponse(Long id) {
        this.id = id;
    }

    public static ClienteResponse converter(Cliente cliente) {
        return new ClienteResponse(cliente.getId());
    }
}
