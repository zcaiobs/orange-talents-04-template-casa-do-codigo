package br.com.zupacademy.caio.casadocodigo.validator;

import br.com.zupacademy.caio.casadocodigo.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFouCNPJValidator implements ConstraintValidator<CPFouCNPJ, String> {

    @Autowired
    EstadoRepository estadoRepository;

    @Override
    public void initialize(CPFouCNPJ params) {

    }

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext constraintValidatorContext) {
        if(documento.length() <= 15) {
            return DocumentoValidator.isCPF(documento);
        } else {
            return DocumentoValidator.isCNPJ(documento);
        }
    }
}
