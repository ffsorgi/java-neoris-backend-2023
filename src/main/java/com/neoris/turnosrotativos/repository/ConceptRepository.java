package com.neoris.turnosrotativos.repository;

import com.neoris.turnosrotativos.entities.Concepto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptRepository extends JpaRepository<Concepto, Integer> {

}
