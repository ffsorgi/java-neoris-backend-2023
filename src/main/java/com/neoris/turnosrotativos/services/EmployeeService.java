package com.neoris.turnosrotativos.services;

import com.neoris.turnosrotativos.dto.EmployeeDTO;
import com.neoris.turnosrotativos.entities.Employee;
import java.util.List;

/**
 *
 * @author Federico Fernando Sorgi Rosenthal
 */
public interface EmployeeService {

    public Employee addEmployee(EmployeeDTO employeeDTO);

    public List<Employee> getEmployees();

    public Employee getEmployeeByID(Integer empleadoId);

    public void deleteEmployeeByID(Integer empleadoId);
}
