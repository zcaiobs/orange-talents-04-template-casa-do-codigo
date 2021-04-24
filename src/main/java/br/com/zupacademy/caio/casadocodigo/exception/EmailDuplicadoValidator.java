package br.com.zupacademy.caio.casadocodigo.exception;

import br.com.zupacademy.caio.casadocodigo.domain.AutorRequest;
import br.com.zupacademy.caio.casadocodigo.repository.AutorRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmailDuplicadoValidator implements Validator {

    AutorRepository autorRepository;

    EmailDuplicadoValidator(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        AutorRequest autorRequest = (AutorRequest) o;
        if(autorRepository.existsAutorByEmail(autorRequest.getEmail())){
            errors.rejectValue("email", "", "Este email já foi cadastrado");
        }
    }
}
