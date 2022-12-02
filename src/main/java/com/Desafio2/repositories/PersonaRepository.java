package com.Desafio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Desafio2.entity.PersonaEntity;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity,Integer> {
}
