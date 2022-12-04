package com.Desafio2.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class DireccionDTO {

    private Integer id;
    private String calle;
    private Float altura;
}
