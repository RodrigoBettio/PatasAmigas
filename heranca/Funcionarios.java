package heranca;

public class Funcionarios extends Pessoa {

    private int id_funcionario;
    private String data_contratacao;
    private String cargo;
    private Float salario;
    private String departamento;

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getData_contratacao() {
        return data_contratacao;
    }

    public void setData_contratacao(String data_contratacao) {
        this.data_contratacao = data_contratacao;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

}
