package br.com.medcontrol.controller;


import br.com.medcontrol.model.Cirurgia;
import br.com.medcontrol.service.CirurgiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/cirurgias")
@RestController
public class CirurgiaController {

    @Autowired
    private CirurgiaService cirurgiaService;

    @GetMapping()
    public ResponseEntity<List<Cirurgia>> getCirurgias(){
        return ResponseEntity.ok(cirurgiaService.getCirurgias());
    }

}
