package heranca;

public class Tutores extends Pessoa {

    private int id_tutor;
    private int animais_custodia;
    private String historico;
    private Boolean status;

    public Tutores(String nome, String nascimento, String genero, String CPF, String logradouro, String numero,String bairro, String cidade, String estado, String pais, String telefone, String email,String hashsenha, int id_tutor, int animais_custodia, String historico, Boolean status) {

        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        this.id_tutor = id_tutor;
        this.animais_custodia = animais_custodia;
        this.historico = historico;
        this.status = status;
    }

    public int getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(int id_tutor) {
        this.id_tutor = id_tutor;
    }

    public int getAnimais_custodia() {
        return animais_custodia;
    }

    public void setAnimais_custodia(int animais_custodia) {
        this.animais_custodia = animais_custodia;
    }

    public String getHistorico() {
        return historico;
    }

    public void setHistorico(String historico) {
        this.historico = historico;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

}
