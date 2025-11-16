package model;

public class Pessoa {
    private String nome;
    private int idade;
    private String categoria;

    public Pessoa(String nome, int idade, String categoria) {
        this.nome = nome;
        this.idade = idade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return nome + " (" + categoria + ", " + idade + " anos)";
    }
}