package model;

import java.util.Scanner;

public class Adotante extends Pessoa implements Papel {

    // Atributos privados da classe Adotantes
    private int id_adotante;
    private PreferenciaAdocao preferencia_adocao;
    private HistoricoAdotante historico_adotante;
    private Boolean status;

    // Construtor da classe Adotante
    public Adotante(String nome, String nascimento, String genero, String CPF, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha,
            int idAdotante, PreferenciaAdocao preferenciaAdocao, HistoricoAdotante historicoAdotante, Boolean status) {

        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        // Inicializa os atributos específicos de Adotante
        this.id_adotante = idAdotante;
        this.preferencia_adocao = preferenciaAdocao;
        this.historico_adotante = historicoAdotante;
        this.status = status;
    }

    @Override
    public void exibirDetalhes() {
        System.out.printf("%-15s %-30","ID do Adotante: \n" + id_adotante);
        System.out.printf("%-15s %-30","Preferência de adoção: \n" + preferencia_adocao);
        System.out.printf("%-15s %-30","Histórico de adoções: \n" + historico_adotante.toString());
        System.out.printf("%-15s %-30","O status de %s é: %s\n", this.getNome(), status ? "Ativo" : "Inativo");
    }

    @Override
    public void editarDetalhes(Scanner scanner) {
        System.out.println("Editando informações de Adotante");
        System.out.println("1 - Preferência de Adoção");
        System.out.println("2 - Histórico de Adoção");
        System.out.println("3 - Status (ativo/inativo)");
        System.out.printf("Escolha o atributo que deseja editar: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (opcao) {
            case 1:
                this.preferencia_adocao.editarPreferencia(scanner);
                break;

            case 2:
                this.historico_adotante.editarHistorico(scanner);
                break;

            case 3:
                System.out.println("Digite o novo status (ativo/inativo):");
                String resposta = scanner.nextLine();
                boolean novoStatus = resposta.equalsIgnoreCase("ativo");
                this.setStatus(novoStatus);
                break;

            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    @Override
    public String getNomePapel() {
        return "Adotante";
    }

    // Chama o construtor
    public int getId_adotante() {
        return id_adotante;
    }

    // Getters e Setters
    public void setId_adotante(int id_adotante) {
        this.id_adotante = id_adotante;
    }

    public PreferenciaAdocao getPreferencia_adocao() {
        return preferencia_adocao;
    }

    public void setPreferencia_adocao(PreferenciaAdocao preferencia_adocao) {
        this.preferencia_adocao = preferencia_adocao;
    }

    public HistoricoAdotante getHistorico_Adotante() {
        return historico_adotante;
    }

    public void setHistorico_adotante(HistoricoAdotante historico_adotante) {
        this.historico_adotante = historico_adotante;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
