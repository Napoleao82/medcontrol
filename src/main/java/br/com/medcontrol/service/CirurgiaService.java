package br.com.medcontrol.service;

import br.com.medcontrol.entity.CirurgiaEntity;
import br.com.medcontrol.model.Cirurgia;
import br.com.medcontrol.repository.CirurgiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CirurgiaService {

    @Autowired
    private CirurgiaRepository cirurgiaRepository;

    public List<Cirurgia> getCirurgias(){
        //TODO implmemetnar o que precisa para reotnrar
        ArrayList<Cirurgia> cirurgias =  new ArrayList<>();

        var cirurgiasBD = cirurgiaRepository.findAll();
        for (CirurgiaEntity cirurgia : cirurgiasBD) {
            Cirurgia a = new Cirurgia();

            a.setCirugiao(cirurgia.getCirugiao());
            a.setPaciente(cirurgia.getPaciente());
            a.setDataCirurgia(cirurgia.getDataCirurgia());
            a.setTipoCirurgia(cirurgia.getTipoCirurgia());
            a.setId(cirurgia.getId());

            cirurgias.add(a);
        }


        return cirurgias;
    }

    public Cirurgia saveCirurgia(Cirurgia cirurgia){
        CirurgiaEntity cirurgiaEntity = new CirurgiaEntity();
        cirurgiaEntity.setCirugiao(cirurgia.getCirugiao());
        //TODO Continuar com o mapeamento dos objetos aqui

        cirurgiaEntity.setPaciente(cirurgia.getPaciente());
        cirurgiaEntity.setDataCirurgia(cirurgia.getDataCirurgia());
        cirurgiaEntity.setTipoCirurgia(cirurgia.getTipoCirurgia());

        //Aqui salvamos o objeto
        cirurgiaRepository.save(cirurgiaEntity);


        //Aqui retornei o ID em que o paciente foi salvo no BD
        cirurgia.setId(cirurgiaEntity.getId());
        return cirurgia;

    }
}
