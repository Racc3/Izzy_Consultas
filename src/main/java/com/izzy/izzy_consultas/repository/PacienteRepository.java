package com.izzy.izzy_consultas.repository;

import com.izzy.izzy_consultas.model.Paciente;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByNomeDePaciente(String nomeDePaciente);
    Optional<Paciente> findByEmail(String email);

    @Query("SELECT p FROM paciente p WHERE LOWER(p.nomeDePaciente) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(p.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<Paciente> buscarPorNomeOuEmail(@Param("keyword") String keyword);
}
