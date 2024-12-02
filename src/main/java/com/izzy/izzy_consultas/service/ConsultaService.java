package com.izzy.izzy_consultas.service;

import com.izzy.izzy_consultas.dto.ConsultaDto;
import com.izzy.izzy_consultas.model.Consulta;
import com.izzy.izzy_consultas.model.Paciente;
import com.izzy.izzy_consultas.model.Profissional;
import com.izzy.izzy_consultas.repository.ConsultaRepository;
import com.izzy.izzy_consultas.repository.PacienteRepository;
import com.izzy.izzy_consultas.repository.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Consulta marcarConsulta(ConsultaDto consultaDto) {
        // Buscar paciente pelo ID
        Paciente paciente = pacienteRepository.findById(consultaDto.getPaciente_Id())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        // Buscar profissional pelo ID
        Profissional profissional = profissionalRepository.findById(consultaDto.getProfissional_Id())
                .orElseThrow(() -> new RuntimeException("Profissional não encontrado!"));

        // Criar a consulta e preencher os dados
        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setProfissional(profissional);
        consulta.setCreatedDate(new Date());

        // Salvar a consulta
        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }
}
