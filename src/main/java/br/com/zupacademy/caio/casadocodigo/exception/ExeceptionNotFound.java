package br.com.zupacademy.caio.casadocodigo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExeceptionNotFound extends RuntimeException {

}
