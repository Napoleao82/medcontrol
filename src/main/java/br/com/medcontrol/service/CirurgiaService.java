package br.com.medcontrol.service;

import br.com.medcontrol.entity.CirurgiaEntity;
import br.com.medcontrol.model.Cirurgia;
import br.com.medcontrol.repository.CirurgiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Cirurgia getCirurgia(Long id){

        Cirurgia cirurgia = new Cirurgia();
        Optional<CirurgiaEntity> cirurgiaBD = cirurgiaRepository.findById(id);

        cirurgia.setId(cirurgiaBD.get().id);
        cirurgia.setTipoCirurgia(cirurgiaBD.get().tipoCirurgia);
        cirurgia.setDataCirurgia(cirurgiaBD.get().dataCirurgia);
        cirurgia.setPaciente(cirurgiaBD.get().Paciente);
        cirurgia.setCirugiao(cirurgiaBD.get().Cirugiao);

        return cirurgia;

        // se cirurgia = nula
        // escreva "cirurgia não encontrada"

    }

    public Cirurgia putCirurgia(Cirurgia cirurgiaAtualizada,long id) {

        Optional<CirurgiaEntity> cirurgiaBD = cirurgiaRepository.findById(id);


        cirurgiaBD.get().setTipoCirurgia(cirurgiaAtualizada.getTipoCirurgia());
        cirurgiaBD.get().setDataCirurgia(cirurgiaAtualizada.getDataCirurgia());
        cirurgiaBD.get().setPaciente(cirurgiaAtualizada.getPaciente());
        cirurgiaBD.get().setCirugiao(cirurgiaAtualizada.getCirugiao());

        CirurgiaEntity cirurgiaSalva = cirurgiaRepository.save(cirurgiaBD.get());

        Cirurgia putCirurgia = new Cirurgia();

        putCirurgia.setTipoCirurgia(cirurgiaSalva.getTipoCirurgia());
        putCirurgia.setDataCirurgia(cirurgiaSalva.getDataCirurgia());
        putCirurgia.setPaciente(cirurgiaSalva.getPaciente());
        putCirurgia.setCirugiao(cirurgiaSalva.getCirugiao());

        return putCirurgia;


    }

    public  Boolean deleteCirurgia(long id) {

        cirurgiaRepository.deleteById(id);

        return true;

    }

}
