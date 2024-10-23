package model;

public class HistoricoTutor {
    private String descricaoT;
    private int numeroAdocoesT;

    // Construtor, getters e setters
    public HistoricoTutor(String descricaoT, int numeroAdocoesT) {
        this.descricaoT = descricaoT;
        this.numeroAdocoesT = numeroAdocoesT;
    }

    public String getDescricaoT() {
        return descricaoT;
    }

    public void setDescricaoT(String descricaoT) {
        this.descricaoT = descricaoT;
    }

    public int getNumeroAdocoesT() {
        return numeroAdocoesT;
    }

    public void setNumeroAdocoes(int numeroAdocoesT) {
        this.numeroAdocoesT = numeroAdocoesT;
    }

    @Override
    public String toString() {
        return "\nDescricao: " + descricaoT + " \nNúmero de adoções: " + numeroAdocoesT;
    }
}
