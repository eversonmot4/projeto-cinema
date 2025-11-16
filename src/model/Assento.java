package model;

public class Assento {
    private char fileira;
    private int numero;
    private boolean ocupado;

    public Assento(char fileira, int numero) {
        this.fileira = fileira;
        this.numero = numero;
        this.ocupado = false;
    }

    public char getFileira() {
        return fileira;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void ocupar() {
        this.ocupado = true;
    }

    public void liberar() {
        this.ocupado = false;
    }

    @Override
    public String toString() {
        return fileira + String.valueOf(numero) + (ocupado ? " [X]" : " [ ]");
    }
}