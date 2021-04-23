package br.com.zupacademy.caio.casadocodigo.exception;

public class ExceptionDto {
    private final String field;
    private final String error;

    public ExceptionDto(String field, String error) {
        this.field = field;
        this.error = error;
    }

    public String getCampo() {
        return field;
    }

    public String getError() {
        return error;
    }
}
