package br.com.zupacademy.caio.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = CPFouCNPJValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CPFouCNPJ {
    String message() default "Valor de atributo não encontrado.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
