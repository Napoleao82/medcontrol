package br.com.medcontrol.entity;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "cirurgia")
@Table(name = "CIRURGIA")
@Data
public class CirurgiaEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    public Long id;

    @Column(name = "CIRURGIAO")
    public String  cirugiao;


    @Column(name = "PACIENTE")
    public String Paciente;


    @Column(name = "DT_CIRURGIA")
    public String dataCirurgia;

    @Column(name = "TIPO_CIRURGIA")
    public String tipoCirurgia;


}
