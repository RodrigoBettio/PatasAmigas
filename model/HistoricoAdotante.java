package model;

import java.util.Scanner;

public class HistoricoAdotante {
    private String detalhes;
    private String descricao;
    private int numeroAdocoes;

    // Construtor, getters e setters
    public HistoricoAdotante(String detalhes, String descricao, int numeroAdocoes) {
        this.detalhes = detalhes;
        this.descricao = descricao;
        this.numeroAdocoes = numeroAdocoes;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumeroAdocoes() {
        return numeroAdocoes;
    }

    public void setNumeroAdocoes(int numeroAdocoes) {
        this.numeroAdocoes = numeroAdocoes;
    }


    public void editarDetalhes(Scanner scanner) {
        System.out.println("Digite os novos detalhes do histórico:");
        String novosDetalhes = scanner.nextLine();
        this.setDetalhes(novosDetalhes);
    }


    @Override
    public String toString() {
        return "\nDescricao: " + descricao + " \nNúmero de adoções: " + numeroAdocoes;
    }
}
