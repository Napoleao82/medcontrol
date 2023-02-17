package br.com.medcontrol.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Cirurgia {

    public String Cirugiao;
    public String Paciente;
    public LocalDateTime dataCirurgia;
    public String tipoCirurgia;
}
