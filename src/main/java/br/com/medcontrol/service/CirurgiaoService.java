package br.com.medcontrol.service;


import br.com.medcontrol.entity.CirurgiaEntity;
import br.com.medcontrol.entity.CirurgiaoEntity;
import br.com.medcontrol.model.Cirurgia;
import br.com.medcontrol.model.Cirurgiao;
import br.com.medcontrol.repository.CirurgiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CirurgiaoService {


    @Autowired
    private CirurgiaoRepository cirurgiaoRepository;


    public Cirurgiao getCirurgiao(long id){
        Cirurgiao cirurgiaoApi = new Cirurgiao();

        try {
            Optional<CirurgiaoEntity> cirurgiaoBD = cirurgiaoRepository.findById(id);

            cirurgiaoApi.setId(cirurgiaoBD.get().getId());
            cirurgiaoApi.setSexo(cirurgiaoBD.get().getSexo());
            cirurgiaoApi.setNome(cirurgiaoBD.get().getNome());
            cirurgiaoApi.setIdade(cirurgiaoBD.get().getIdade());
            cirurgiaoApi.setEspecialidade(cirurgiaoBD.get().getEspecialidade());
            cirurgiaoApi.setRM(cirurgiaoBD.get().getRm());

            //cirurgiaoApi = new Cirurgiao(cirurgiaoBD.get().getNome(), cirurgiaoApi.getIdade(), cirurgiaoApi.getEspecialidade(), cirurgiaoApi.getRM(),
                   // cirurgiaoApi.getIdade(), cirurgiaoApi.getId());


            return cirurgiaoApi;

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cirurgiao não encontrado");
        }
            return cirurgiaoApi;


        }


    public List<Cirurgiao> getcirurgioes() {                        // buscar todos cirurgioes do banco de dados

        ArrayList<Cirurgiao> cirurgioes = new ArrayList<>();       // criando uma lista de de cirurgioes

        try {                                                     // cuidando pra se der pane

            List<CirurgiaoEntity> cirurgiaoBD = cirurgiaoRepository.findAll();  // buscando no banco de dados

            for (CirurgiaoEntity cirurgiao : cirurgiaoBD) {        // esse percorre todos os cirurgioes retornados do banco de dados
              
                Cirurgiao a = new Cirurgiao ();                     // instanciando um novo cirurgiao
                 a.setNome(cirurgiao.getNome());
                 a.setEspecialidade(cirurgiao.getEspecialidade());
                 a.setRM(cirurgiao.getRm());
                 a.setIdade(cirurgiao.getIdade());
                 a.setId(cirurgiao.getId());

                 cirurgioes.add(a);

            }
            return cirurgioes; // retornadno todos cirurgioes


        } catch (Exception e) { // se der erro vai retornar essa mensagem
            e.printStackTrace();
            System.out.println("cirurgião não encontrados");


        }
        return cirurgioes; //retornar todos cirurgioes


    }

    public Cirurgiao saveCirurgiao(Cirurgiao cirurgiao){

        try{
            CirurgiaoEntity cirurgiaoEntity = new CirurgiaoEntity();

            // TODO: Continuar com o mapeamento dos objetos aqui

            cirurgiaoEntity.setNome(cirurgiao.getNome());
            cirurgiaoEntity.setEspecialidade(cirurgiao.getEspecialidade());
            cirurgiaoEntity.setRm(cirurgiao.getRM());
            cirurgiaoEntity.setIdade(cirurgiao.getIdade());
            cirurgiaoEntity.setSexo(cirurgiao.getSexo());


            // Aqui salvamos o objeto
            cirurgiaoRepository.save(cirurgiaoEntity);

            // Aqui retornei o ID em que o paciente foi salvo no BD
            cirurgiao.setId(cirurgiaoEntity.getId());

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("cirurgiao não pode ser salvo");

            return cirurgiao;
        }

        return cirurgiao;

    }

    public Cirurgiao putCirurgiao(Cirurgiao cirurgiaoAtualizado, long id){

        try{
            Optional<CirurgiaoEntity> cirurgiaoBD = cirurgiaoRepository.findById(id);

            cirurgiaoBD.get().setNome(cirurgiaoAtualizado.getNome());
            cirurgiaoBD.get().setEspecialidade(cirurgiaoAtualizado.getEspecialidade());
            cirurgiaoBD.get().setRm(cirurgiaoAtualizado.getRM());
            cirurgiaoBD.get().setIdade(cirurgiaoAtualizado.getIdade());
            cirurgiaoBD.get().setSexo(cirurgiaoAtualizado.getSexo());


            CirurgiaoEntity cirurgiaoSalvo = cirurgiaoRepository.save(cirurgiaoBD.get());

            Cirurgiao putCirurgiao = new Cirurgiao();

            putCirurgiao.setNome(cirurgiaoSalvo.getNome());
            putCirurgiao.setEspecialidade(cirurgiaoSalvo.getEspecialidade());
            putCirurgiao.setRM(cirurgiaoSalvo.getRm());
            putCirurgiao.setIdade(cirurgiaoSalvo.getIdade());
            putCirurgiao.setSexo(cirurgiaoSalvo.getSexo());
            putCirurgiao.setId(cirurgiaoSalvo.getId());

            return putCirurgiao;

        } catch (Exception e) {

            e.printStackTrace();
            System.out.println("Cirurgião não pode ser editado");

        }
        return cirurgiaoAtualizado;
    }

    public boolean deleteCirurgiao(long id){

        try{
            Optional<CirurgiaoEntity> buscarid = cirurgiaoRepository.findById(id);

            if (buscarid.isEmpty()) {
                System.out.println("Cirurgião não encontrado");
            }else {
                System.out.println("Cirurgião apagado com sucesso");
                cirurgiaoRepository.deleteById(id);
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Cirurgião não pode ser deletado");
        }
        return true;
    }


}
