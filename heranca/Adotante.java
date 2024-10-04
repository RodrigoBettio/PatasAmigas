package heranca;

public class Adotante extends Pessoa {

    private String id_adotante;
    private String preferencia_adocao;
    private String historico_adocoes;
    private Boolean status;

    public Adotante(String nome, String nascimento, String genero, String CPF, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha, String id_adotante, String preferencia_adocao, String historico_adocoes, Boolean status) {
        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        this.id_adotante = id_adotante;
        this.preferencia_adocao = preferencia_adocao;
        this.historico_adocoes = historico_adocoes;
        this.status = status;
    }

    public String getId_adotante() {
        return id_adotante;
    }

    public void setId_adotante(String id_adotante) {
        this.id_adotante = id_adotante;
    }

    public String getPreferencia_adocao() {
        return preferencia_adocao;
    }

    public void setPreferencia_adocao(String preferencia_adocao) {
        this.preferencia_adocao = preferencia_adocao;
    }

    public String getHistorico_adocoes() {
        return historico_adocoes;
    }

    public void setHistorico_adocoes(String historico_adocoes) {
        this.historico_adocoes = historico_adocoes;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
