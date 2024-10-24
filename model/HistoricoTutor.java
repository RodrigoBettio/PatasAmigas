package model;

public class HistoricoTutor {
    private String descricaoHistoricoTutor;
    private int numeroAdocoesTutor;

    // Construtor, getters e setters
    public HistoricoTutor(String descricaoHistoricoTutor, int numeroAdocoesTutor) {
        this.descricaoHistoricoTutor = descricaoHistoricoTutor;
        this.numeroAdocoesTutor = numeroAdocoesTutor;
    }

    public String getDescricaoHistoricoTutor() {
        return descricaoHistoricoTutor;
    }

    public void setDescricaoHistoricoTutor(String descricaoT) {
        this.descricaoHistoricoTutor = descricaoT;
    }

    public int getNumeroAdocoesTutor() {
        return numeroAdocoesTutor;
    }

    public void setNumeroAdocoes(int numeroAdocoesT) {
        this.numeroAdocoesTutor = numeroAdocoesT;
    }

    @Override
    public String toString() {
        return "\nDescricao: " + descricaoHistoricoTutor + " \nNúmero de adoções: " + numeroAdocoesTutor;
    }
}
