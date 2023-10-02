package br.com.medcontrol.model;

import br.com.medcontrol.model.Pessoa;

public class Paciente extends Pessoa {
    // Atributo da classe br.com.medcontrol.model.Paciente
    private String tipoDeCirurgia;


    public Paciente(String nome, int idade, char sexo) {
        super(nome, idade, sexo);
    }

    public Paciente() {
        super();
    }
}
