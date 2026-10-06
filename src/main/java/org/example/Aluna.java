package org.example;

public class Aluna {

    String nome;
    double[] notas;

    // Construtor
    public Aluna(String nome, int quantidadeNotas) {
        this.nome = nome;
        this.notas = new double[quantidadeNotas];
    }

    // Adiciona uma nota em determinada posição
    public void adicionarNota(int posicao, double nota) {
        notas[posicao] = nota;
    }

    // Calcula a média das notas
    public double calcularMedia() {

        double soma = 0;

        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.length;
    }

    // Verifica se a aluna foi aprovada
    public boolean passou() {
        return calcularMedia() >= 6;
    }

    // Mostra as informações da aluna
    public void mostrarResultado() {

        System.out.println("\n===== RESULTADO =====");
        System.out.println("Aluna: " + nome);

        System.out.println("Notas:");

        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }

        System.out.printf("Média: %.2f%n", calcularMedia());

        if (passou()) {
            System.out.println("Situação: APROVADA!");
        } else {
            System.out.println("Situação: REPROVADA!");
        }
    }
}
