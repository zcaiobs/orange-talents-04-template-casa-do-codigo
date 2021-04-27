package br.com.zupacademy.caio.casadocodigo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {DateFutureValueValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DateFutureValue {
    String message() default "Data inválida.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    String fieldName();
}
