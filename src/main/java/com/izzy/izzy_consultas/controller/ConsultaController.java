package com.izzy.izzy_consultas.controller;

import com.izzy.izzy_consultas.dto.ConsultaDto;
import com.izzy.izzy_consultas.model.Consulta;
import com.izzy.izzy_consultas.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> marcarConsulta(@RequestBody ConsultaDto consultaDto) {
        Consulta novaConsulta = consultaService.marcarConsulta(consultaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaConsulta);
    }



    @GetMapping
    public ResponseEntity<List<Consulta>> listarConsultas() {
        return ResponseEntity.ok(consultaService.listarConsultas());
    }
}

