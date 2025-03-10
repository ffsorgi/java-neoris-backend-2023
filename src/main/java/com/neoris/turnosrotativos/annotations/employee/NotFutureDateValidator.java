package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.exceptions.BadRequestException;
import com.neoris.turnosrotativos.utils.GenerateOptionals;
import java.time.LocalDate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotFutureDateValidator implements ConstraintValidator<NotFutureDate, LocalDate> {

    private String message;

    @Override
    public void initialize(NotFutureDate contrainAnnotation) {
        message = contrainAnnotation.message();
    }

    public boolean isValid(LocalDate date, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalLocalDate(date).isPresent()) {
            LocalDate now = LocalDate.now();

            if (date.isAfter(now)) {
                throw new BadRequestException(message);
            }

        }

        return true;

    }
}
