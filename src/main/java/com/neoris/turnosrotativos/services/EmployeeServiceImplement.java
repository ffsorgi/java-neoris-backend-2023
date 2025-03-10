package com.neoris.turnosrotativos.services;

import com.neoris.turnosrotativos.dto.EmployeeDTO;
import com.neoris.turnosrotativos.entities.Employee;
import com.neoris.turnosrotativos.exceptions.NotFoundException;
import com.neoris.turnosrotativos.mapper.EmployeeDTOToEmployee;
import com.neoris.turnosrotativos.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */
@Service
public class EmployeeServiceImplement implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EmployeeDTOToEmployee mapper;

    @Override
    public Employee addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = mapper.map(employeeDTO);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByID(Integer empleadoId) {

        Optional<Employee> optionalEmployee;

        try {
            optionalEmployee = employeeRepository.findById(empleadoId);
        } catch (DataAccessException e) {
            throw new ServerErrorException("Error al encontrar el usuario por id", e);
        }

        if (!optionalEmployee.isPresent()) {
            throw new NotFoundException("No se encontró el empleado con Id: " + empleadoId);
        }

        return optionalEmployee.get();
    }

    @Override
    public void deleteEmployeeByID(Integer empleadoId) {

        try {
            employeeRepository.deleteById(empleadoId);
        } catch (DataAccessException e){
            throw new NotFoundException("No se encontró el empleado con Id: "+empleadoId);
        }

    }
}
