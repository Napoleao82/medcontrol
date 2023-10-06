package br.com.medcontrol.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "paciente")
@Table(name = "PACIENTE")
@Data

public class PacienteEntity {
    @Id
    @Column(name = "ID")
    @GeneratedValue
     public long id;


    @Column(name = "NOME")
     public String  nome;

    @Column(name = "IDADE")
     public int idade;

    @Column(name = "SEXO")
     public char sexo;



}
