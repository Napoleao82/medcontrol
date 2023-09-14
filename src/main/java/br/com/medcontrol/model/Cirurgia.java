package br.com.medcontrol.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
public class Cirurgia {

    public long id;
    public String  Cirugiao;
    public String Paciente;
    public LocalDateTime dataCirurgia;
    public String tipoCirurgia;
}
