package com.izzy.izzy_consultas.service;

import com.izzy.izzy_consultas.model.Paciente;
import com.izzy.izzy_consultas.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    public Paciente atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        Optional<Paciente> pacienteOptional = pacienteRepository.findById(id);
        if (pacienteOptional.isPresent()) {
            Paciente paciente = pacienteOptional.get();
            paciente.setNomeDePaciente(pacienteAtualizado.getNomeDePaciente());
            paciente.setEmail(pacienteAtualizado.getEmail());
            // Atualizar outros campos conforme necessário
            return pacienteRepository.save(paciente);
        }
        return null;
    }

    public boolean excluirPaciente(Long id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
