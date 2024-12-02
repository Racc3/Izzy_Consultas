package com.izzy.izzy_consultas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.izzy.izzy_consultas.dto.ConsultaDto;
import com.izzy.izzy_consultas.dto.PacienteDto;
import com.izzy.izzy_consultas.dto.ProfissionalDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;
@Entity
@Data
@Table(name = "consultas")
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultaId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profissional_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Profissional profissional;

    // Método para converter Consulta em ConsultaDTO
    public ConsultaDto toDto() {
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(consultaId);
        consultaDto.setCreatedDate(createdDate);

        // Adiciona dados do paciente
        if (paciente != null) {
            consultaDto.setPaciente_Id(paciente.getPacienteId());
            consultaDto.setNomeDePaciente(paciente.getNomeDePaciente());
        }

        // Adiciona dados do profissional
        if (profissional != null) {
            consultaDto.setProfissional_Id(profissional.getProfissionalId());
            consultaDto.setNomeDoProfissional(profissional.getNomeDoProfissional());
            consultaDto.setEspecialidade(profissional.getEspecialidade());
        }

        return consultaDto;
    }
}
