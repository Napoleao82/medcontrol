package br.com.medcontrol.service;


import br.com.medcontrol.entity.CirurgiaEntity;
import br.com.medcontrol.entity.CirurgiaoEntity;
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


    public Cirurgiao getCirurgiao(Log id){
        Cirurgiao cirurgiaoApi = new Cirurgiao();

        try {
            Optional<CirurgiaoEntity> cirurgiaoBD = cirurgiaoRepository.findById(id);

            cirurgiaoBD.get().setId(cirurgiaoApi.getId());
            cirurgiaoBD.get().setEspecialidade(cirurgiaoApi.getEspecialidade());
            cirurgiaoBD.get().setRm(cirurgiaoApi.getRM());
            cirurgiaoBD.get().setNome(cirurgiaoApi.getNome());

            return cirurgiaoApi;

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Cirurgiao não encontrado");
        }
            return cirurgiaoApi;


        }


    public List<Cirurgiao> getcirurgioes() { // buscar todos cirurgioes do banco de dados

        ArrayList<Cirurgiao> cirurgioes = new ArrayList<>(); // criando uma lista de de cirurgioes

        try { // cuidando pra se der pane

            List<CirurgiaoEntity> cirurgiaoBD = cirurgiaoRepository.findAll();  // buscando no banco de dados

            for (CirurgiaoEntity cirurgiao : cirurgiaoBD) {  // esse percorre todos os cirurgioes retornados do banco de dados
              
                Cirurgiao a = new Cirurgiao(cirurgiao.getNome(), cirurgiao.getIdade(), cirurgiao.getSexo(), cirurgiao.getEspecialidade(), cirurgiao.getRm(); // instanciando um novo cirurgiao



                return cirurgioes; // retornadno todos cirurgioes

            }

        } catch (Exception e) { // se der erro vai retornar essa mensagem
            e.printStackTrace();
            System.out.println("cirurgioes não encontrados");


        }
        return cirurgioes; //retornar todos cirurgioes



    }
}
