package com.neoris.turnosrotativos.controllers;

import com.neoris.turnosrotativos.dto.EmployeeDTO;
import com.neoris.turnosrotativos.entities.Employee;
import com.neoris.turnosrotativos.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Federico Fernando Sorgi Rosenthal
 */

//Fix de endpoints segun HU
@RestController
@RequestMapping("empleado")
@Validated
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @CrossOrigin(origins = "*")
    @PostMapping("")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeService.addEmployee(employeeDTO);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employeeList = employeeService.getEmployees();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{empleadoId}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable("empleadoId")Integer empleadoId){
        Employee employee = employeeService.getEmployeeByID(empleadoId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping("/{empleadoId}")
    public ResponseEntity<Void> deleteEmployeeByID(@PathVariable("empleadoId") Integer empleadoId) {
        employeeService.deleteEmployeeByID(empleadoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
