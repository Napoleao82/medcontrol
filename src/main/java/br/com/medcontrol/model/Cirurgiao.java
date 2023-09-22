package br.com.medcontrol.model;

    public class Cirurgiao extends Pessoa {


        // Atributos da classe br.com.medcontrol.model.Pessoa.Cirurgiao
        private String especialidade;
        private String RM; // Registro Médico

        public Cirurgiao(String nome, int idade, char sexo) {
            super(nome, idade, sexo);
        }

        public String getEspecialidade() {
            return especialidade;
        }

        public void setEspecialidade(String especialidade) {
            this.especialidade = especialidade;
        }

        public String getRM() {
            return RM;
        }

        public void setRM(String RM) {
            this.RM = RM;
        }
    }

