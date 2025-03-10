package com.neoris.turnosrotativos.controllers;

import com.neoris.turnosrotativos.entities.Concepto;
import com.neoris.turnosrotativos.services.ConceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Fix de endpoints segun HU
@RestController
@RequestMapping("concepto")
public class ConceptController {

    @Autowired
    ConceptService conceptService;

    @GetMapping("")
    public ResponseEntity<List<Concepto>> getConcepts(){
        List<Concepto> concepts = conceptService.getConcepts();
        return new ResponseEntity<>(concepts, HttpStatus.OK);
    }
}
