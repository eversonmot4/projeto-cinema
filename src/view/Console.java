package view;

import java.util.Scanner;
import model.*;

public class Console {
    private Scanner scanner = new Scanner(System.in);

    public Pessoa cadastrarPessoa() {
        System.out.println("\n++=== Cadastro de Pessoa ===++");
        System.out.print("Nome: ");
        String nome = lerLinha();

        int idade = lerInteiro("Idade: ", 0, 120);

        String categoria;
        while (true) {
            System.out.print("Categoria (Normal, Estudante, Idoso, Professor): ");
            categoria = scanner.nextLine().trim();
            if (categoria.equalsIgnoreCase("Normal") ||
                    categoria.equalsIgnoreCase("Estudante") ||
                    categoria.equalsIgnoreCase("Idoso") ||
                    categoria.equalsIgnoreCase("Professor")) {
                break;
            }
            System.out.println("Categoria inválida. Tente novamente.");
        }

        return new Pessoa(nome, idade, categoria);
    }

    public int escolherSala() {
        System.out.print("Digite o número da sala (1-5): ");
        return lerInteiro(" ", 1, 5);
    }

    public char escolherFileira() {
        System.out.print("Digite a letra da fileira (A-T): ");
        return scanner.next().toUpperCase().charAt(0);
    }

    public int escolherCadeira() {
        return lerInteiro("Digite o número da cadeira (1-10): ", 1, 10);
    }

    public void mostrarIngresso(Ingresso ingresso) {
        System.out.println("\n--=== Ingresso Gerado ===--");
        System.out.println(ingresso);
    }

    public void mostrarErro(String mensagem) {
        System.out.println("Erro: " + mensagem);
    }


    public int lerInteiro(String prompt, int min, int max) {
        int valor;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                scanner.nextLine();
                if (valor >= min && valor <= max) {
                    return valor;
                }
            } else {
                scanner.nextLine();
            }
            System.out.println("Valor inválido. Tente novamente.");
        }
    }

    public String lerLinha() {
        return scanner.nextLine().trim();
    }
}