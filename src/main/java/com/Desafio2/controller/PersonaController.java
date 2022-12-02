package com.Desafio2.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Desafio2.domain.MensajeDTO;
import com.Desafio2.domain.PersonaDTO;
import com.Desafio2.service.PersonaService;

@RestController
@RequestMapping("/contacto")
public class PersonaController {
    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> findAll() {
        return ResponseEntity.ok(personaService.findAll());
    }

    @PostMapping
    public ResponseEntity<MensajeDTO> add(@RequestBody PersonaDTO personaDTO){
        return ResponseEntity.ok(personaService.add(personaDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PersonaDTO> findOne(@PathVariable Integer id) {
        return ResponseEntity.ok(personaService.findOne(id));
    }
}
