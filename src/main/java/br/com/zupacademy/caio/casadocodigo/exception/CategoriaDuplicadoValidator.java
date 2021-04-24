package br.com.zupacademy.caio.casadocodigo.exception;

import br.com.zupacademy.caio.casadocodigo.domain.CategoriaRequest;
import br.com.zupacademy.caio.casadocodigo.repository.CategoriaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoriaDuplicadoValidator implements Validator {

    CategoriaRepository categoriaRepository;

    CategoriaDuplicadoValidator(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(CategoriaRequest.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }
        CategoriaRequest categoriaRequest = (CategoriaRequest) o;
        if(categoriaRepository.existsCategoriaByNome(categoriaRequest.getNome())) {
            errors.rejectValue("nome", "", "Este nome já foi cadastrado");
        }
    }
}
