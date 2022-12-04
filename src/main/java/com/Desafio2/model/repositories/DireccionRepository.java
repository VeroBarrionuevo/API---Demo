package com.Desafio2.model.repositories;

import com.Desafio2.model.entity.DireccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DireccionRepository extends JpaRepository <DireccionEntity,Integer> {
}
