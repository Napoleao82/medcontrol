package br.com.medcontrol.controller;


import br.com.medcontrol.model.Paciente;
import br.com.medcontrol.service.PacienteService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RequestMapping("Paciente")
@RestController

public class PacienteControler {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> getPacientes(){

        return ResponseEntity.ok(pacienteService.getPacientes());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> GetPaciente(@PathVariable Long id) {

        return ResponseEntity.ok(pacienteService.getPaciente(id));

    }

    @PostMapping
    public ResponseEntity<Paciente> savePaciente(@RequestBody Paciente pacienteRequest) {
        return ResponseEntity.ok(pacienteService.savePaciente(pacienteRequest));

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Paciente> putPaciente (@RequestBody Paciente pacienteRequest, @PathVariable long id) {
        return ResponseEntity.ok(pacienteService.putPaciente(pacienteRequest,id));
    }

    @DeleteMapping( "/{id}")
    public  ResponseEntity<Boolean> deletPaciente(@PathVariable long id) {

        return ResponseEntity.ok(pacienteService.deletePaciente(id));
    }


}
