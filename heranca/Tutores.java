package heranca;

public class Tutores extends Pessoa {

    private int id_tutor;
    private int animais_custodia;
    private String historico;
    private Boolean status;

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
