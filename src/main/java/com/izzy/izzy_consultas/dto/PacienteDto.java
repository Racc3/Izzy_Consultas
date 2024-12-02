package com.izzy.izzy_consultas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDto {

    private Long pacienteId;
    private String nomeDePaciente;

}
