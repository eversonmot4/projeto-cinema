package model;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Cinema {
    private Sala[] salas;
    private List<Ingresso> historico;

    public Cinema() {
        this.salas = new Sala[5];
        for (int i = 0; i < 5; i++) {
            salas[i] = new Sala(i + 1);
        }
        historico = new ArrayList<>();
    }

    public void cadastrarFilmeNaSala(int numeroSala, Filme filme) {
        if (numeroSala >= 1 && numeroSala <= 5) {
            salas[numeroSala - 1].setFilme(filme);
        }
    }

    public Sala getSala(int numeroSala) {
        if (numeroSala >= 1 && numeroSala <= 5) {
            return salas[numeroSala - 1];
        }
        return null;
    }

    public void exibirSalas() {
        System.out.println("----- Salas Disponíveis -----");
        for (Sala sala : salas) {
            Filme f = sala.getFilme();
            String titulo = (f != null) ? f.getTitulo() : "Nenhum filme";
            System.out.printf("Sala %d: %s%n", sala.getNumero(), titulo);
        }
        System.out.println("-----------------------------");
    }


    public void mostrarMapaSala(int numeroSala) {
        Sala sala = getSala(numeroSala);
        if (sala != null) {
            System.out.println("\nMapa da Sala " + numeroSala + ":");
            sala.exibirMapa();
        }
    }

    public void registrarCompra(Ingresso ingresso) {
        historico.add(ingresso);
    }

    public void gerarRelatorioOcupacao() {
        System.out.println("\n=== Relatório de Ocupação ===");
        for (Sala sala : salas) {
            int ocupados = sala.contarAssentosOcupados();
            int total = sala.getTotalAssentos();
            double porcentagem = (ocupados * 100.0) / total;
            System.out.printf("Sala %d: %d/%d assentos ocupados (%.1f%%)%n",
                    sala.getNumero(), ocupados, total, porcentagem);
        }
    }

    public void exportarHistoricoParaTxt(String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            for (Ingresso ingresso : historico) {
                writer.write(ingresso.toString() + "\n");
            }
            System.out.println("\nHistórico exportado para " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao exportar histórico: " + e.getMessage());
        }
    }
}