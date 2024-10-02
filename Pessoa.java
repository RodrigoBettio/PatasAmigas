
public class Pessoa {

    private String nome;
    private String nascimento;
    private String genero;
    private String CPF;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String telefone;
    private String email;
    private String hashsenha;

    public Pessoa(String nome, String nascimento, String genero, String CPF, String logradouro, String numero,
            String bairro, String cidade, String estado, String pais, String telefone, String email, String hashsenha) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.genero = genero;
        this.CPF = CPF;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.telefone = telefone;
        this.email = email;
        this.hashsenha = hashsenha;

    }

    public void ToString() {
        System.out.println("Nome: " + nome);
        System.out.println("Nascimento: " + nascimento);
        System.out.println("Gênero: " + genero);
        System.out.println("CPF: " + CPF);
        System.out.println("Endereço: " + logradouro + ", " + numero + ", " + bairro + ", " + cidade + ", " + estado + ", " + pais);
        System.out.println("Telefone: " + telefone);
        System.out.println("Email: " + email);
    }
}
