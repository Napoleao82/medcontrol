package br.com.medcontrol.model;

public class Pessoa {
        // Atributos

        private long id;
        private String nome;
        private int idade;
        private char sexo;

        // Construtor
        public Pessoa(String nome, int idade, char sexo) {
            this.nome = nome;
            this.idade = idade;
            this.sexo = sexo;
        }

    public Pessoa() {

    }

    public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public char getSexo() {
            return sexo;
        }

        public void setSexo(char sexo) {
            this.sexo = sexo;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }


}
