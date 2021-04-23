package br.com.zupacademy.caio.casadocodigo.exception;

public class ExceptionDto {
    private final String field;
    private final String message;

    public ExceptionDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
