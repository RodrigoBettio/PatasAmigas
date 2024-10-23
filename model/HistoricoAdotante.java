package model;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class HistoricoAdotante {
    private String descricao;
    private int numeroAdocoes;
    private LocalDate dataUltimaAdocao;
    private List<Animal> animaisAdotados;
 

    public HistoricoAdotante(String descricao, int numeroAdocoes, LocalDate dataUltimaAdocao, List<Animal> animaisAdotados) {
        this.descricao = descricao;
        this.numeroAdocoes = numeroAdocoes;
        this.dataUltimaAdocao = dataUltimaAdocao;
        this.animaisAdotados = animaisAdotados;
    }

    // Getters e Setters
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

    public LocalDate getDataUltimaAdocao() {
        return dataUltimaAdocao;
    }

    public void setDataUltimaAdocao(LocalDate dataUltimaAdocao) {
        this.dataUltimaAdocao = dataUltimaAdocao;
    }

    public List<Animal> getAnimaisAdotados() {
        return animaisAdotados;
    }

    public void setAnimaisAdotados(List<Animal> animaisAdotados) {
        this.animaisAdotados = animaisAdotados;
    }


    public void editarHistorico(Scanner scanner) {
        System.out.println("Digite os novos detalhes do histórico:");
        String novoHistorico = scanner.nextLine();
        this.setDescricao(novoHistorico);
    }

    @Override
    public String toString() {
        return "Histórico de Adoções: " +
               "\nDescrição: " + descricao +
               "\nNúmero de adoções: " + numeroAdocoes +
               "\nData da última adoção: " + dataUltimaAdocao +
               "\nAnimais adotados: " + animaisAdotados;
    }
}

    




