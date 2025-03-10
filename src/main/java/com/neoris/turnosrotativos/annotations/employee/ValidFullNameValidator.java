package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.exceptions.BadRequestException;
import com.neoris.turnosrotativos.utils.GenerateOptionals;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintValidator;

//Podria usar @Pattern pero decidí hacer una anotación personalizada.
public class ValidFullNameValidator implements ConstraintValidator<ValidFullName, String> {

    private String field;

    @Override
    public void initialize(ValidFullName constraintAnnotation) {
        field = constraintAnnotation.field();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalString(value).isPresent()) {
            String regex = "^[a-zA-Z ]+$";

            if (!value.matches(regex)) {
                throw new BadRequestException("Solo se permiten letras en el campo ‘" + field + "’.");
            }
        }

        return true;
    }

}
