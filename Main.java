
import heranca.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Visualizar pessoas cadastradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            switch (escolha) {
                case 1:
                    CadastrarPessoa();
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    VisualizarPessoa();
                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 3);
        scanner.close();

    }

    public static Pessoa CadastrarPessoa() {
        Scanner scanner = new Scanner(System.in);

        String nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha;

        System.out.print("Digite o nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento: ");
        nascimento = scanner.nextLine();

        System.out.println("Digite o gênero : ('M' para masculino, 'F' para feminino e 'O' para outros)");
        genero = scanner.nextLine();

        System.out.println("Digite o CPF: (ex.: 123.123.123-12)");
        CPF = scanner.nextLine();

        System.out.print("Digite o logradouro: ");
        logradouro = scanner.nextLine();

        System.out.print("Digite o número: ");
        numero = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        bairro = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        cidade = scanner.nextLine();

        System.out.print("Digite o estado: ");
        estado = scanner.nextLine();

        System.out.print("Digite o país: ");
        pais = scanner.nextLine();

        System.out.println("Digite o telefone: (ex.: '11 11111-1111')");
        telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        email = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        hashsenha = generateHash(senha);

        System.out.print("Tipo de pessoa (1 - Tutor, 2 - Adotante, 3 - Funcionário): ");
        int tipoPessoa = scanner.nextInt();
        Pessoa novaPessoa = null;

        switch (tipoPessoa) {
            case 1:
                System.out.print("Digite o id do Tutor: ");
                int id_tutor = scanner.nextInt();

                System.out.print("Quantos animais estão sob sua custódia? ");
                int animaisCustodia = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha para tirar do buffer

                System.out.print("Digite o histórico do Tutor: ");
                String historico = scanner.nextLine();

                System.out.print("Tutor está ativo? (true/false): ");
                boolean statusTutor = scanner.nextBoolean();

                novaPessoa = new Tutores(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_tutor, animaisCustodia, historico, statusTutor);
                break;

            case 2:
                System.out.print("Digite o ID do adotante: ");
                int id_adotante = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha para tirar do buffer
                
                System.out.print("Qual a sua preferência de adoção?");
                String preferenciaAdocao = scanner.nextLine();

                System.out.print("Digite o histórico das adoções: ");
                String historicoAdocao = scanner.nextLine();

                System.out.print("O adotante está ativo? (true/false):");
                boolean statusAdotante = scanner.nextBoolean();

                novaPessoa = new Adotante(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_adotante, preferenciaAdocao, historicoAdocao, statusAdotante);
                break;

            case 3:
                System.out.print("Digite o ID do funcionário: ");
                int id_funcionario = scanner.nextInt();
                scanner.nextLine(); // Consumir a nova linha para tirar do buffer

                System.out.print("Digite a data de contratação: ");
                String dataContratacao = scanner.nextLine();

                System.out.print("Digite o cargo do funcionário: ");
                String cargo = scanner.nextLine();

                System.out.print("Digite o salário do funcionário: ");
                float salario = scanner.nextFloat();
                scanner.nextLine(); // Consumir a nova linha para tirar do buffer

                System.out.print("Digite o departamento do funcionário: ");
                String departamento = scanner.nextLine();

                novaPessoa = new Funcionarios(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_funcionario, dataContratacao, cargo, salario, departamento);
                break;

            default:
                System.out.println("Tipo de pessoa inválido.");
        }

        listaPessoas.add(novaPessoa);
        return novaPessoa;

    }

    public static void VisualizarPessoa() {
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("---- Pessoas ----");
            System.out.println(pessoa);

            if (pessoa instanceof Tutores tutor) { 

                System.out.printf("\n%s é um Tutor\n", pessoa.getNome());
                System.out.println("Tutor ID: " + tutor.getId_tutor());
                System.out.println("Animais sob Custódia:" + tutor.getAnimais_custodia());
                System.out.printf("Historico de %s: %s\n", pessoa.getNome(), tutor.getHistorico());
                System.out.printf("O status de %s eh: %b\n", pessoa.getNome(), tutor.getStatus());

            } else if (pessoa instanceof Adotante adotante) {

                System.out.printf("\n%s é um Adotante\n", pessoa.getNome());
                System.out.println("ID do Adotante: " + adotante.getId_adotante());
                System.out.println("Preferência de adoção: " + adotante.getPreferencia_adocao());
                System.out.println("Histórico de adoções: " + adotante.getHistorico_adocoes());
                System.out.printf("O status de %s é: %b\n", pessoa.getNome(), adotante.getStatus());

            } else if (pessoa instanceof Funcionarios funcionario) {

                System.out.printf("\n%s é um Funcionário\n", pessoa.getNome());
                System.out.println("ID do Funcionário: " + funcionario.getId_funcionario());
                System.out.println("Data de contratação: " + funcionario.getData_contratacao());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.printf("Salário: R$ %.2f\n", funcionario.getSalario());
                System.out.println("Departamento: " + funcionario.getDepartamento());
            }
        }
    }

    public static String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
