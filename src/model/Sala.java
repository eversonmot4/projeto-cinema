package model;

public class Sala {
    private int numero;
    private Assento[][] assentos;
    private Filme filme;

    public Sala(int numero) {
        this.numero = numero;
        this.assentos = new Assento[20][10];

        char letraFileira = 'A';
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                assentos[i][j] = new Assento((char)(letraFileira + i), j + 1);
            }
        }
    }

    public int getNumero() {
        return numero;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Assento getAssento(char fileira, int numero) {
        int i = fileira - 'A';
        int j = numero - 1;
        if (i >= 0 && i < 20 && j >= 0 && j < 10) {
            return assentos[i][j];
        } else {
            return null;
        }
    }

    public boolean reservarAssento(char fileira, int numero) {
        Assento assento = getAssento(fileira, numero);
        if (assento != null && !assento.isOcupado()) {
            assento.ocupar();
            return true;
        }
        return false;
    }

    public void liberarAssento(char fileira, int numero) {
        Assento assento = getAssento(fileira, numero);
        if (assento != null) {
            assento.liberar();
        }
    }

    public void exibirMapa() {
        System.out.println("Mapa de Assentos da Sala " + numero + ":");
        for (int i = 0; i < 20; i++) {
            System.out.print((char)('A' + i) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(assentos[i][j].isOcupado() ? "[X]" : "[ ]");
            }
            System.out.println();
        }
    }

    public int contarAssentosOcupados() {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (assentos[i][j].isOcupado()) count++;
            }
        }
        return count;
    }

    public int getTotalAssentos() {
        return 200;
    }
}