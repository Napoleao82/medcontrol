package br.com.medcontrol.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "cirurgiao")
@Table(name = "CIRURGIAO")
@Data

public class CirurgiaoEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public Long id;

    @Column(name = "NOME")
    public String  nome;

    @Column(name = "ESPECIALIDADE")
    public String  especialidade;

    @Column(name = "RM")
    public String  rm;


    @Column(name = "IDADE")
    public int idade;

    @Column(name = "SEXO")
    public char sexo;


}
