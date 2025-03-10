package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.exceptions.BadRequestException;
import com.neoris.turnosrotativos.utils.GenerateOptionals;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */
public class AdultValidator implements ConstraintValidator<Adult, LocalDate> {

    @Override
    public void initialize(Adult constraintAnnotation) {
    }

    @Override
    public boolean isValid(LocalDate dateOfBirth, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalLocalDate(dateOfBirth).isPresent()) {
            LocalDate today = LocalDate.now();
            int age = Period.between(dateOfBirth, today).getYears();

            if (age < 18) {
                throw new BadRequestException("La edad del empleado no puede ser menor a 18 años.”");
            }
        }

        return true;
    }

}
