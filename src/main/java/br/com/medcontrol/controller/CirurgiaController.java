package br.com.medcontrol.controller;


import br.com.medcontrol.model.Cirurgia;
import br.com.medcontrol.service.CirurgiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("cirurgias")
@RestController
public class CirurgiaController {

    @Autowired
    private CirurgiaService cirurgiaService;

    @GetMapping()
    public ResponseEntity<List<Cirurgia>> getCirurgias() {

        return ResponseEntity.ok(cirurgiaService.getCirurgias());
    }


    //TODO COMO QUE EU VOU PEGAR UM PARAMETRO, NO CASO O ID DA CIRURGIA
    @GetMapping("/{id}")
    public ResponseEntity<Cirurgia> getCirurgia(@PathVariable Long id) {

        return ResponseEntity.ok(cirurgiaService.getCirurgia(id));
    }

    @PostMapping
    public ResponseEntity<Cirurgia> saveCirurgia(@RequestBody Cirurgia cirurgiaRequest) {
        return ResponseEntity.ok(cirurgiaService.saveCirurgia(cirurgiaRequest));

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Cirurgia> putCirurgia (@RequestBody Cirurgia cirurgiaRequest, @PathVariable long id) {
        return ResponseEntity.ok(cirurgiaService.putCirurgia(cirurgiaRequest,id));
    }

    @DeleteMapping( "/{id}")
    public  ResponseEntity<Boolean> deletCirurgia (@PathVariable long id) {

        return ResponseEntity.ok(cirurgiaService.deleteCirurgia(id));
    }


}