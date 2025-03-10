package com.neoris.turnosrotativos.services;

import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.repository.ConceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConceptServiceImplement implements ConceptService{

    @Autowired
    ConceptRepository conceptRepository;

    @Override
    public List<Concepto> getConcepts() {
        List<Concepto> allConcepts = conceptRepository.findAll();

        List<Concepto> filteredConcepts = allConcepts.stream()
                .filter(c -> c.getHsMinimo() != null && c.getHsMaximo() != null)
                .map(c -> {
                    Concepto filteredConcepto = new Concepto();
                    filteredConcepto.setId(c.getId());
                    filteredConcepto.setNombre(c.getNombre());
                    filteredConcepto.setLaborable(c.getLaborable());
                    filteredConcepto.setHsMinimo(c.getHsMinimo());
                    filteredConcepto.setHsMaximo(c.getHsMaximo());
                    return filteredConcepto;
                })
                .collect(Collectors.toList());

        return filteredConcepts;
    }
}
