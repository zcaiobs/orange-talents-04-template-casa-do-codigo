package br.com.zupacademy.caio.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsValueValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsValue {

    String message() default "Nome de atributo não encontrado.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    String fieldName();
    Class<?> domainClass();
}
