
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

        // Exibe o menu somente ate o momento em que o usuário escolhe a opção 'Sair'
        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Visualizar pessoas cadastradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            // Switch Case para definir as ações de acordo com a escolha
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

    // Cadastro de pessoa e definição do tipo (tutor adotante ou funcionário)
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

         // Inicializa uma nova pessoa
        Pessoa novaPessoa = new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        System.out.print("Essa pessoa é um tutor? (true/false): ");
        boolean ehTutor = scanner.nextBoolean();

        if (ehTutor) {
            System.out.print("Digite o id do Tutor: ");
            int id_tutor = scanner.nextInt();

            System.out.print("Quantos animais estão sob sua custódia? ");
            int animaisCustodia = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite o histórico do Tutor: ");
            String historico = scanner.nextLine();

            System.out.print("Tutor está ativo? (true/false): ");
            boolean statusTutor = scanner.nextBoolean();

            // Cria um objeto Tutor e o adiciona à pessoa
            novaPessoa = new Tutores(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_tutor, animaisCustodia, historico, statusTutor);
        }

        System.out.print("Essa pessoa é um adotante? (true/false): ");
        boolean ehAdotante = scanner.nextBoolean();

        if (ehAdotante) {
            System.out.print("Digite o ID do adotante: ");
            int id_adotante = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Qual a sua preferência de adoção? ");
            String preferenciaAdocao = scanner.nextLine();

            System.out.print("Digite o histórico das adoções: ");
            String historicoAdocao = scanner.nextLine();

            System.out.print("O adotante está ativo? (true/false): ");
            boolean statusAdotante = scanner.nextBoolean();

            // Adiciona os dados do Adotante
            novaPessoa = new Adotante(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_adotante, preferenciaAdocao, historicoAdocao, statusAdotante);
        }

        System.out.print("Essa pessoa é um funcionário? (true/false): ");
        boolean ehFuncionario = scanner.nextBoolean();

        if (ehFuncionario) {
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

            // Adiciona os dados do Funcionário
            novaPessoa = new Funcionarios(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_funcionario, dataContratacao, cargo, salario, departamento);
        }

// Adiciona a nova pessoa na lista de pessoas
        listaPessoas.add(novaPessoa);
        return novaPessoa;
    }

    // Exibição dos dados da pessoa cadastrada
    // Operador 'instanceof' utilizado para verificar a qual das subclasses da classe 'Pessoa' o objeto 'pessoa' pertence e exibir seus dados específicos
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

    // Função que gera o hash SHA-256 da string (senha do usuário)
    public static String generateHash(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(encodedhash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Função auxiliar que converte o array de bytes em uma string hexadecimal
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
