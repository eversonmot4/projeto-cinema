package app;

import model.*;
import view.Console;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema();
        Console view = new Console();
        Scanner scanner = new Scanner(System.in);

        boolean executando = true;

        while (executando) {
            System.out.println("\n=====================================");
            System.out.println("           MENU PRINCIPAL             ");
            System.out.println("=====================================");
            System.out.println("1. Cadastrar Filme em Sala");
            System.out.println("2. Listar Salas e Filmes");
            System.out.println("3. Comprar Ingresso");
            System.out.println("4. Mostrar Mapa de Assentos");
            System.out.println("5. Gerar Relatório de Ocupação");
            System.out.println("6. Exportar Histórico para TXT");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = lerInteiro(scanner);

            System.out.println();

            switch (opcao) {
                case 1:
                    cadastrarFilme(cinema, view);
                    break;
                case 2:
                    cinema.exibirSalas();
                    System.out.println();
                    break;
                case 3:
                    comprarIngresso(cinema, view);
                    System.out.println();
                    break;
                case 4:
                    mostrarMapa(cinema, view);
                    System.out.println();
                    break;
                case 5:
                    cinema.gerarRelatorioOcupacao();
                    System.out.println();
                    break;
                case 6:
                    cinema.exportarHistoricoParaTxt("historico_ingressos.txt");
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Saindo do sistema. Até logo.");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    System.out.println();
            }
        }
        scanner.close();
    }

    private static void cadastrarFilme(Cinema cinema, Console view) {
        int numeroSala;
        while (true) {
            numeroSala = view.escolherSala();
            if (numeroSala >= 1 && numeroSala <= 5) {
                break;
            }
            view.mostrarErro("Número de sala inválido. Escolha entre 1 e 5.");
        }

        System.out.print("Digite o título do filme: ");
        String titulo = view.lerLinha();

        int duracao = view.lerInteiro("Digite a duração do filme (em minutos): ", 1, 500);

        System.out.print("Digite o gênero do filme: ");
        String genero = view.lerLinha();

        Filme filme = new Filme(titulo, duracao, genero);
        cinema.cadastrarFilmeNaSala(numeroSala, filme);
        System.out.println("Filme cadastrado com sucesso na sala " + numeroSala + "!");
    }

    private static void comprarIngresso(Cinema cinema, Console view) {
        boolean temFilme = false;
        for (int i = 1; i <= 5; i++) {
            Sala sala = cinema.getSala(i);
            if (sala != null && sala.getFilme() != null) {
                temFilme = true;
                break;
            }
        }

        if (!temFilme) {
            System.out.println("Nenhuma sala possui filme cadastrado no momento.");
            return;
        }

        Pessoa pessoa = view.cadastrarPessoa();

        int salaEscolhida;
        Sala sala;
        while (true) {
            salaEscolhida = view.escolherSala();
            sala = cinema.getSala(salaEscolhida);
            if (sala == null) {
                view.mostrarErro("Sala inválida.");
            } else if (sala.getFilme() == null) {
                view.mostrarErro("Sala sem filme atribuído.");
            } else {
                break;
            }
        }

        cinema.mostrarMapaSala(salaEscolhida);

        char fileira;
        while (true) {
            fileira = view.escolherFileira();
            if (fileira < 'A' || fileira > 'T') {
                view.mostrarErro("Fileira inválida. Use letras de A a T.");
            } else {
                break;
            }
        }

        int numeroCadeira;
        while (true) {
            numeroCadeira = view.escolherCadeira();
            if (numeroCadeira < 1 || numeroCadeira > 10) {
                view.mostrarErro("Número da cadeira inválido. Use números de 1 a 10.");
            } else {
                break;
            }
        }

        boolean reservado = sala.reservarAssento(fileira, numeroCadeira);
        if (!reservado) {
            view.mostrarErro("Assento já ocupado ou inválido.");
            return;
        }

        Assento assento = sala.getAssento(fileira, numeroCadeira);
        Ingresso ingresso = new Ingresso(pessoa, sala, assento);
        cinema.registrarCompra(ingresso);
        view.mostrarIngresso(ingresso);
    }

    private static void mostrarMapa(Cinema cinema, Console view) {
        int salaNum;
        Sala sala;
        while (true) {
            salaNum = view.escolherSala();
            sala = cinema.getSala(salaNum);
            if (sala == null) {
                view.mostrarErro("Sala inválida.");
            } else {
                break;
            }
        }
        cinema.mostrarMapaSala(salaNum);
    }

    private static int lerInteiro(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada inválida. Digite um número: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}