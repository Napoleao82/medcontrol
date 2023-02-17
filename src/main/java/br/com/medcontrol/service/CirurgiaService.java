package br.com.medcontrol.service;

import br.com.medcontrol.model.Cirurgia;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CirurgiaService {

    public List<Cirurgia> getCirurgias(){
        Cirurgia cirurgia = new Cirurgia();

        cirurgia.setDataCirurgia(LocalDateTime.now());
        cirurgia.setTipoCirurgia("Fimose");
        cirurgia.setCirugiao("Ana Carolina");
        cirurgia.setPaciente("Otto");
        ArrayList<Cirurgia> cirurgias =  new ArrayList<>();
        cirurgias.add(cirurgia);

        return cirurgias;
    }
}
