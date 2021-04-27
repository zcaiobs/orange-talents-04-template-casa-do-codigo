package br.com.zupacademy.caio.casadocodigo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateFutureValueValidator implements ConstraintValidator<DateFutureValue, Object> {

    String domainAttribute;

    @Override
    public void initialize(DateFutureValue params) {
        domainAttribute = params.fieldName();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Date future = (Date) value;
        long diff = new Date().getTime() - future.getTime();
        return diff < 1;
    }
}
