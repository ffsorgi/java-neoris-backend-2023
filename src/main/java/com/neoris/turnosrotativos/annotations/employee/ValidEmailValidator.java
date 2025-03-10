package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.exceptions.BadRequestException;
import com.neoris.turnosrotativos.utils.GenerateOptionals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidEmailValidator implements ConstraintValidator<ValidEmail, String> {
    //A pesar de tener la anotacion @Email y el @Pattern preferi hacer una personalizada para menejar como devuelve la exception.
    //También por si "en un futuro" es necesario implementar otras validaciones para el mismo, como :
    //para valdiar el dominio, ya sea que sean de empresas conocidas como ( gmail,hotmail,outlook, etc) para que no se creen cuentas con emails temporales
    //o para validar que el mismo sea de la empresa correspondiente.

    @Override
    public void initialize(ValidEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalString(email).isPresent()) {

            //Valida un ejemplo asi: ejemplo@dominio.com
            String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            if (!email.matches(regex)) {
                throw new BadRequestException("El email ingresado no es correcto.");
            }

        }

        return true;
    }
}
