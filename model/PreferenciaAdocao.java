package model;
import java.util.Scanner;

public class PreferenciaAdocao {
    private String descricao;
    private int numeroAdocoes;
    private TipoAnimal tipoAnimal;
    private String idadePreferida;
    private String tamanhoPreferido;
    private String sexoPreferido;
    private boolean necessidadeEspeciais;

    public PreferenciaAdocao(String descricao, int numeroAdocoes, TipoAnimal tipoAnimal, String idadePreferida, String tamanhoPreferido, String sexoPreferido, boolean necessidadeEspeciais) {
        this.descricao = descricao;
        this.numeroAdocoes = numeroAdocoes;
        this.tipoAnimal = tipoAnimal;
        this.idadePreferida = idadePreferida;
        this.tamanhoPreferido = tamanhoPreferido;
        this.sexoPreferido = sexoPreferido;
        this.necessidadeEspeciais = necessidadeEspeciais;
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

    public TipoAnimal getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(TipoAnimal tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getIdadePreferida() {
        return idadePreferida;
    }

    public void setIdadePreferida(String idadePreferida) {
        this.idadePreferida = idadePreferida;
    }

    public String getTamanhoPreferido() {
        return tamanhoPreferido;
    }

    public void setTamanhoPreferido(String tamanhoPreferido) {
        this.tamanhoPreferido = tamanhoPreferido;
    }

    public String getSexoPreferido() {
        return sexoPreferido;
    }

    public void setSexoPreferido(String sexoPreferido) {
        this.sexoPreferido = sexoPreferido;
    }

    public boolean isNecessidadeEspeciais() {
        return necessidadeEspeciais;
    }

    public void setNecessidadeEspeciais(boolean necessidadeEspeciais) {
        this.necessidadeEspeciais = necessidadeEspeciais;
    }

    public void editarPreferencia(Scanner scanner) {
        System.out.println("Digite os novos detalhes de Preferência:");
        String novoHistorico = scanner.nextLine();
        this.setDescricao(novoHistorico);
    }

    // Método toString()
    @Override
    public String toString() {
        return "Preferências de Adoção: " +
               "\nDescrição: " + descricao +
               "\nNúmero de adoções desejadas: " + numeroAdocoes +
               "\nTipo de Animal: " + tipoAnimal +
               "\nIdade preferida: " + idadePreferida +
               "\nTamanho preferido: " + tamanhoPreferido +
               "\nSexo preferido: " + sexoPreferido +
               "\nNecessidades Especiais: " + (necessidadeEspeciais ? "Sim" : "Não");
    }
}

