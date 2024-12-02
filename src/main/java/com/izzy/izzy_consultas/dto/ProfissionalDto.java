package com.izzy.izzy_consultas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalDto {

    private Long profissionalId;
    private String email;
    private String nomeDoProfissional;

}
