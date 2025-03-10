package com.neoris.turnosrotativos.repository;

import com.neoris.turnosrotativos.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Federico Fernando Sorgi Rosenthal
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Employee findByNroDocumento(Integer numeroDocumento);

    Employee findByEmail(String email);

    void deleteById(Integer empleadoId);

}
