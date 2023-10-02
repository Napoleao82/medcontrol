package br.com.medcontrol.service;


import br.com.medcontrol.entity.CirurgiaEntity;
import br.com.medcontrol.entity.PacienteEntity;
import br.com.medcontrol.model.Paciente;
import br.com.medcontrol.repository.PacienteRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



 @Service
 public class PacienteService {

  @Autowired
  private PacienteRepository pacienteRepository;


  public Paciente getPaciente(Long id) { // buscando paciente
   Paciente pacienteApi = new Paciente(); // instanciando um novo paciente

   try { // cuidadno pra se der erro
    Optional<PacienteEntity> pacienteBD = pacienteRepository.findById(id); // não sei

    pacienteBD.get().setId(pacienteApi.getId());// implementando para buscar o id do paciente
    pacienteBD.get().setSexo(pacienteApi.getSexo() + "");
    pacienteBD.get().setNome(pacienteApi.getNome());
    pacienteBD.get().setIdade(pacienteApi.getIdade() + "");


    return pacienteApi; // retornando o paciente

   } catch (Exception e) { // se der erro vai retornar isso aqui
    e.printStackTrace();
    System.out.println("paciente não encontrado");
   }
   return pacienteApi;

  }


  public List<Paciente> getPacientes() {

   ArrayList<Paciente> pacientes = new ArrayList<>();

   try {

    List<PacienteEntity> pacienteBD = pacienteRepository.findAll();

    for (PacienteEntity paciente : pacienteBD) {
     var nome = "cavalaria";
     var idade = 1;
     var sexo = 'm';
     Paciente a = new Paciente(nome, idade, sexo);

     return pacientes;

    }

   } catch (Exception e) {
    e.printStackTrace();
    System.out.println("paciente não encontrado");


   }
   return pacientes;
  }

  public Paciente savePaciente(Paciente paciente) {

   try {
    PacienteEntity pacienteEntity = new PacienteEntity();
    pacienteEntity.setIdade(paciente.getIdade() + "");
    pacienteEntity.setSexo(paciente.getSexo() + "");
    pacienteEntity.setNome(paciente.getNome());

    // Aqui salvamos o objeto
    pacienteRepository.save(pacienteEntity);

    // Aqui retornei o ID em que o paciente foi salvo no BD
    paciente.setId(pacienteEntity.getId());

   } catch (Exception e) {
    e.printStackTrace();
    System.out.println("Paciente não pode ser salvo");

    return paciente;

   }
   return paciente;
  }

  public Paciente putPaciente(Paciente pacienteAtualizado, long id) {

   try {
    Optional<PacienteEntity> pacienteBD = pacienteRepository.findById(id);
    pacienteBD.get().setNome(pacienteAtualizado.getNome());
    pacienteBD.get().setSexo(pacienteAtualizado.getSexo());
    pacienteBD.get().setIdade(pacienteAtualizado.getIdade() + "");

    PacienteEntity pacienteSalvo = pacienteRepository.save(pacienteBD.get());

    Paciente putPaciente = new Paciente();

    putPaciente.setNome(pacienteSalvo.getNome());
    putPaciente.setIdade(Integer.parseInt(pacienteSalvo.getIdade()));
    putPaciente.setSexo(pacienteSalvo.getSexo());

    return putPaciente;

   } catch (Exception e) {

    e.printStackTrace();
    System.out.println("Paciente não pode ser editado");

   }
   return pacienteAtualizado;
  }

  public Boolean deletePaciente(long id) {


   try {
    Optional<PacienteEntity> buscarid = pacienteRepository.findById(id);

    if (buscarid.isEmpty()) {
     System.out.println("Paciente não encontrado");
    } else {
     System.out.println("paciente apagado com sucesso");

     PacienteRepository.deleteById(id);
    }

   } catch (Exception e) {

    e.printStackTrace();
    System.out.println(" paciente não pode ser deletado");
   }
   return true;

  }
 }