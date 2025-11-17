package model;

public class Ingresso {
    private Pessoa pessoa;
    private Sala sala;
    private Assento assento;
    private double precoFinal;
    private static final double PRECO_BASE = 20.00;

    public Ingresso(Pessoa pessoa, Sala sala, Assento assento) {
        this.pessoa = pessoa;
        this.sala = sala;
        this.assento = assento;
        this.precoFinal = calcularPreco();
    }

    private double calcularPreco() {
        String categoria = pessoa.getCategoria().toLowerCase();

        if (pessoa.getIdade() >= 60 || categoria.equals("idoso")) {
            return 0.0;
        } else if (categoria.equals("estudante")) {
            return PRECO_BASE * 0.5;
        } else if (categoria.equals("professor")) {
            return PRECO_BASE * 0.7;
        } else {
            return PRECO_BASE;
        }
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Sala getSala() {
        return sala;
    }

    public Assento getAssento() {
        return assento;
    }

    public double getPrecoFinal() {
        return precoFinal;
    }

    @Override
    public String toString() {
        return "Ingresso:\n" +
                "Pessoa: " + pessoa.getNome() + " (" + pessoa.getCategoria() + ")\n" +
                "Sala: " + sala.getNumero() + " | Filme: " + sala.getFilme().getTitulo() + "\n" +
                "Assento: " + assento.getFileira() + assento.getNumero() + "\n" +
                String.format("Preço final: R$ %.2f", precoFinal);
    }
}