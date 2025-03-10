package com.neoris.turnosrotativos.mapper;

import com.neoris.turnosrotativos.dto.EmployeeDTO;
import com.neoris.turnosrotativos.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDTOToEmployee implements IMapper<EmployeeDTO, Employee>{
    @Override
    public Employee map(EmployeeDTO in) {
        Employee employee = new Employee();

        employee.setNroDocumento(in.getNroDocumento());
        employee.setNombre(in.getNombre());
        employee.setApellido(in.getApellido());
        employee.setEmail(in.getEmail());
        employee.setFechaNacimiento(in.getFechaNacimiento());
        employee.setFechaIngreso(in.getFechaIngreso());

        return employee;
    }
}
