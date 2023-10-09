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


    public List<Cirurgia> getCirurgias() {
        //TODO implmemetnar o que precisa para reotnrar
        ArrayList<Cirurgia> cirurgias = new ArrayList<>();

        try {
            // Recupere cirurgias do repositório (presumindo que cirurgiaRepository é um repositório válido)
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
        } catch (Exception e) {

            e.printStackTrace();
            System.out.println(" cirurgia não encontrada tente novamente ");

        }

        return cirurgias;
    }


    public Cirurgia saveCirurgia(Cirurgia cirurgia) {
        try {
            CirurgiaEntity cirurgiaEntity = new CirurgiaEntity();
            cirurgiaEntity.setCirugiao(cirurgia.getCirugiao());

            // TODO: Continuar com o mapeamento dos objetos aqui
            cirurgiaEntity.setPaciente(cirurgia.getPaciente());
            cirurgiaEntity.setDataCirurgia(cirurgia.getDataCirurgia());
            cirurgiaEntity.setTipoCirurgia(cirurgia.getTipoCirurgia());

            // Aqui salvamos o objeto
            cirurgiaRepository.save(cirurgiaEntity);

            // Aqui retornei o ID em que o paciente foi salvo no BD
            cirurgia.setId(cirurgiaEntity.getId());


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cirurgia não pode ser salva");
}

         return cirurgia;
    }

    public Cirurgia getCirurgia(Long id) {
        Cirurgia cirurgia = new Cirurgia();
        try {
            cirurgia = new Cirurgia();
            Optional<CirurgiaEntity> cirurgiaBD = cirurgiaRepository.findById(id);

            cirurgia.setId(cirurgiaBD.get().getId());
            cirurgia.setTipoCirurgia(cirurgiaBD.get().getTipoCirurgia());
            cirurgia.setDataCirurgia(cirurgiaBD.get().getDataCirurgia());
            cirurgia.setPaciente(cirurgiaBD.get().getPaciente());
            cirurgia.setCirugiao(cirurgiaBD.get().getCirugiao());

            return cirurgia;

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("cirurgia não encontrada");
        }
        return cirurgia;
    }

    public Cirurgia putCirurgia(Cirurgia cirurgiaAtualizada, long id) {

        try {
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


        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("cirurgia não pode ser editada");

        }
        return cirurgiaAtualizada;
    }

    public Boolean deleteCirurgia(long id) {
        try {
            Optional<CirurgiaEntity> buscarid = cirurgiaRepository.findById(id);

            if (buscarid.isEmpty()) {
                System.out.println("cirurgia não encontrada");
            } else {
                System.out.println("cirurgia apagada com sucesso");

                cirurgiaRepository.deleteById(id);
            }

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("está cirurgia não pode ser deletada");
        }
        return true;
    }


}









