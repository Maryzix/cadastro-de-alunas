package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ArrayList para armazenar as alunas
        ArrayList<Aluna> alunas = new ArrayList<>();

        // HashMap para relacionar nome e média
        HashMap<String, Double> medias = new HashMap<>();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== SISTEMA DE REGISTRO DE ALUNAS =====");
            System.out.println("1 - Cadastrar aluna");
            System.out.println("2 - Listar alunas");
            System.out.println("3 - Consultar média");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {

                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {

                    case 1:

                        System.out.print("\nDigite o nome da aluna: ");
                        String nome = scanner.nextLine();

                        if (medias.containsKey(nome)) {

                            System.out.println(
                                    "Essa aluna já está cadastrada!"
                            );

                            break;
                        }

                        Aluna aluna = new Aluna(nome, 3);

                        for (int i = 0; i < aluna.notas.length; i++) {

                            boolean notaValida = false;

                            while (!notaValida) {

                                try {

                                    System.out.print(
                                            "Digite a nota "
                                                    + (i + 1)
                                                    + " (0 a 10): "
                                    );

                                    double nota = scanner.nextDouble();

                                    if (nota < 0 || nota > 10) {

                                        System.out.println(
                                                "A nota deve estar entre 0 e 10!"
                                        );

                                    } else {

                                        aluna.adicionarNota(i, nota);

                                        notaValida = true;
                                    }

                                } catch (InputMismatchException e) {

                                    System.out.println(
                                            "Digite apenas números!"
                                    );

                                    scanner.nextLine();
                                }
                            }
                        }

                        alunas.add(aluna);

                        medias.put(
                                aluna.nome,
                                aluna.calcularMedia()
                        );

                        System.out.println(
                                "\nAluna cadastrada com sucesso!"
                        );

                        aluna.mostrarResultado();

                        break;

                    case 2:

                        System.out.println(
                                "\n===== ALUNAS CADASTRADAS ====="
                        );

                        if (alunas.isEmpty()) {

                            System.out.println(
                                    "Nenhuma aluna cadastrada."
                            );

                        } else {

                            for (Aluna a : alunas) {

                                System.out.printf(
                                        "Nome: %s | Média: %.2f%n",
                                        a.nome,
                                        medias.get(a.nome)
                                );
                            }
                        }

                        break;

                    case 3:

                        System.out.print(
                                "\nDigite o nome da aluna: "
                        );

                        String nomeBusca = scanner.nextLine();

                        if (medias.containsKey(nomeBusca)) {

                            double media = medias.get(nomeBusca);

                            System.out.println(
                                    "Média de "
                                            + nomeBusca
                                            + ": "
                                            + media
                            );

                            if (media >= 6) {

                                System.out.println(
                                        "Situação: APROVADA!"
                                );

                            } else {

                                System.out.println(
                                        "Situação: REPROVADA!"
                                );
                            }

                        } else {

                            System.out.println(
                                    "Aluna não encontrada."
                            );
                        }

                        break;

                    case 0:

                        System.out.println(
                                "\nEncerrando o sistema..."
                        );

                        break;

                    default:

                        System.out.println(
                                "\nOpção inválida!"
                        );
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "\nDigite apenas números para escolher uma opção!"
                );

                scanner.nextLine();
            }
        }

        scanner.close();

        System.out.println("Programa encerrado.");
    }
}