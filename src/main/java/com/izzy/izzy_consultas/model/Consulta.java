package com.izzy.izzy_consultas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.izzy.izzy_consultas.dto.ConsultaDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "paciente_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Paciente é obrigatório")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "profissional_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull(message = "Profissional é obrigatório")
    private Profissional profissional;

    // Método para converter para DTO
    public ConsultaDto toDto() {
        ConsultaDto consultaDto = new ConsultaDto();
        consultaDto.setId(consultaId);
        consultaDto.setCreatedDate(createdDate);

        if (paciente != null) {
            consultaDto.setPaciente_Id(paciente.getPacienteId());
            consultaDto.setNomeDePaciente(paciente.getNomeDePaciente());
        }

        if (profissional != null) {
            consultaDto.setProfissional_Id(profissional.getProfissionalId());
            consultaDto.setNomeDoProfissional(profissional.getNomeDoProfissional());
            consultaDto.setEspecialidade(profissional.getEspecialidade());
        }

        return consultaDto;
    }
}
