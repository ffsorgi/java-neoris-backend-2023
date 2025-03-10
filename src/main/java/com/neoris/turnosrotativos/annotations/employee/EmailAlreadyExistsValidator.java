package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.entities.Employee;
import com.neoris.turnosrotativos.exceptions.ConflictException;
import com.neoris.turnosrotativos.repository.EmployeeRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.neoris.turnosrotativos.utils.GenerateOptionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.server.ServerErrorException;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */
public class EmailAlreadyExistsValidator implements ConstraintValidator<EmailAlreadyExists, String> {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void initialize(EmailAlreadyExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalString(email).isPresent()) {

            try {
                Employee employee = employeeRepository.findByEmail(email);

                if (employee != null) {
                    throw new ConflictException("Ya existe un empleado con el email ingresado.");
                }
            } catch (DataAccessException e) {
                throw new ServerErrorException("Error al buscar empleado por email.", e);
            }

        }

        return true;
    }

}
