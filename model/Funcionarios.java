package model;

public class Funcionarios extends Pessoa implements Papel {

    // Atributos privados da classe Funcionarios
    private int id_funcionario;
    private String data_contratacao;
    private String cargo;
    private Float salario;
    private String departamento;


    // Construtor da classe Funcionarios
    public Funcionarios(String nome, String nascimento, String genero, String CPF, String logradouro, String numero, String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha, int id_funcionario, String data_contratacao, String cargo, Float salario, String departamento) {

        // Chama o construtor da classe Pessoa para inicializar os atributos que foram herdados
        super(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        this.id_funcionario = id_funcionario;
        this.data_contratacao = data_contratacao;
        this.cargo = cargo;
        this.salario = salario;
        this.departamento = departamento;
    }

    @Override
    public void exibirDetalhes(){
    System.out.println("ID do Funcionário: " + id_funcionario);
    System.out.println("Data de contratação: " + data_contratacao);
    System.out.println("Cargo: " + cargo);
    System.out.printf("Salário: R$ %.2f\n", salario);
    System.out.println("Departamento: " + departamento);

    }

    // Chama o construtor
    public int getId_funcionario() {
        return id_funcionario;
    }


    // Getters e Setters
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
