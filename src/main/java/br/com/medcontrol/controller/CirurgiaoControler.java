package br.com.medcontrol.controller;


import br.com.medcontrol.model.Cirurgiao;
import br.com.medcontrol.service.CirurgiaoService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RequestMapping("Cirurgiao")
@RestController


public class CirurgiaoControler {

    @Autowired
    private CirurgiaoService cirurgiaoService;

    @GetMapping
    public ResponseEntity<List<Cirurgioes>> getCirurgioes(){

        return ResponseEntity.ok(cirurgiaoService.getcirurgioes());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Cirurgiao> GetCirurgiao(@PathVariable Long id) {

        return ResponseEntity.ok(cirurgiaoService.getCirurgiao(id));

    }

    @PostMapping
    public ResponseEntity<Cirurgiao> saveCirurgiao(@RequestBody Cirurgiao cirurgiaoResquest) {
        return ResponseEntity.ok(cirurgiaoService.saveCirurgiao(cirurgiaoResquest));

    }

    @PutMapping("/{id}")
    public  ResponseEntity<Cirurgiao> putCirurgiao (@RequestBody Cirurgiao cirurgiaoRequest, @PathVariable long id) {
        return ResponseEntity.ok(cirurgiaoService.putCirurgiao(cirurgiaoRequest,id));
    }

    @DeleteMapping( "/{id}")
    public  ResponseEntity<Boolean> deletCirurgiao(@PathVariable long id) {

        return ResponseEntity.ok(cirurgiaoService.deleteCirurgiao(id));
    }


}
