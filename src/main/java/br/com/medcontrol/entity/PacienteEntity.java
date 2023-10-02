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
     public String  Nome;

    @Column(name = "IDADE")
     public String Idade;

    @Column(name = "SEXO")
     public char Sexo;






}
