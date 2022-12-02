package com.Desafio2.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.Desafio2.domain.MensajeDTO;
import com.Desafio2.domain.PersonaDTO;
import com.Desafio2.mappers.PersonaMapper;
import com.Desafio2.repositories.PersonaRepository;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;

    private final PersonaMapper personaMapper;

    public PersonaService(PersonaRepository personaRepository, PersonaMapper personaMapper){
        this.personaRepository = personaRepository;
        this.personaMapper = personaMapper;
    }

    public List<PersonaDTO> findAll(){
        return personaRepository
                .findAll()
                .stream()
                .map(personaEntity -> personaMapper.personaEntityToPersonaDTO(personaEntity))
                .collect(Collectors.toList());
    }

    public PersonaDTO findOne(Integer id){
        return Optional
                .ofNullable(id)
                .map(ID ->personaRepository.findById(id).get())
                .map(entity ->personaMapper.personaEntityToPersonaDTO(entity))
                .orElse(new PersonaDTO());
    }

    public MensajeDTO add(PersonaDTO personaDTO){
        return Optional
                .ofNullable(personaDTO)
                .map(dto ->personaMapper.personaDTOToPersonaEntity(dto))
                .map(entity ->personaRepository.save(entity))
                .map(entity ->personaMapper.personEntityToMensajeDTO(entity))
                .orElse(new MensajeDTO());
    }


}
