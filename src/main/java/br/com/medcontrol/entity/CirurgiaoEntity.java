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
    public String  Nome;

    @Column(name = "ESPECIALIDADE")
    public String  Especialidade;

    @Column(name = "RM")
    public String  Rm;


    @Column(name = "IDADE")
    public String Idade;

    @Column(name = "SEXO")
    public String Sexo;


}
