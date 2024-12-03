package com.izzy.izzy_consultas.service;

import com.izzy.izzy_consultas.model.Paciente;
import com.izzy.izzy_consultas.model.Profissional;
import com.izzy.izzy_consultas.repository.ProfissionalRepository;
import org.hibernate.bytecode.spi.ProxyFactoryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfissionalService {
    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Profissional salvarProfissional(Profissional profissional) {
        return profissionalRepository.save(profissional);
    }

    public List<Profissional> listarProfissionais() {
        return profissionalRepository.findAll();
    }

    public Profissional atualizarProfissional(Long id, Profissional profissionalAtualizado) {
        Optional<Profissional> profissionalOptional = profissionalRepository.findById(id);
        if (profissionalOptional.isPresent()) {
            Profissional profissional = profissionalOptional.get();
            profissional.setNomeDoProfissional(profissionalAtualizado.getNomeDoProfissional());
            profissional.setEmail(profissionalAtualizado.getEmail());
            // Atualizar outros campos conforme necessário
            return profissionalRepository.save(profissional);
        }
        return null;
    }

    public boolean excluirProfissional(Long id) {
        if (profissionalRepository.existsById(id)) {
            profissionalRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
