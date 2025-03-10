package com.neoris.turnosrotativos.annotations.employee;

import com.neoris.turnosrotativos.entities.Employee;
import com.neoris.turnosrotativos.exceptions.ConflictException;
import com.neoris.turnosrotativos.repository.EmployeeRepository;
import com.neoris.turnosrotativos.utils.GenerateOptionals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.server.ServerErrorException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentNumberAlreadyExistsValidator implements ConstraintValidator<DocumentNumberAlreadyExists, Integer> {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void initialize(DocumentNumberAlreadyExists constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer nroDocumento, ConstraintValidatorContext constraintValidatorContext) {

        if (GenerateOptionals.optionalInteger(nroDocumento).isPresent()) {

            try {
                Employee employee = employeeRepository.findByNroDocumento(nroDocumento);

                if (employee != null) {
                    throw new ConflictException("Ya existe un empleado con el documento ingresado.");
                }
            } catch (DataAccessException e) {
                throw new ServerErrorException("Error al buscar empleado por numero de documento.", e);
            }

        }

        return true;
    }
}
