
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

        // Exibe o menu somente até o momento em que o usuário escolhe a opção 'Sair'
        do {
            System.out.println();
            System.out.println("---- Menu ----");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Editar pessoas cadastradas");
            System.out.println("3. Visualizar pessoas cadastradas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            // Switch Case para definir as ações de acordo com a escolha
            switch (escolha) {
                case 1:
                    System.out.println();
                    CadastrarPessoa(scanner);
                    System.out.println("Pessoa cadastrada com sucesso!");
                    break;

                case 2:
                    System.out.println();
                    Pessoa pessoa = EscolherPessoa(scanner);
                    EditarPessoa(scanner,pessoa);
                    System.out.println("Pessoa editada com sucesso!");
                    break;

                case 3:
                    System.out.println();
                    VisualizarDadosPessoa();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (escolha != 4);
        scanner.close();
    }

    // Cadastro de pessoa e definição do tipo (tutor adotante ou funcionário)
    public static Pessoa CadastrarPessoa(Scanner scanner) {

        String nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha;

        System.out.print("Digite o nome: ");
        nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento: ");
        nascimento = scanner.nextLine();

        System.out.print("Digite o gênero : ('M' para masculino, 'F' para feminino e 'O' para outros)");
        genero = scanner.nextLine();

        System.out.print("Digite o CPF: (ex.: 123.123.123-12)");
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

        System.out.print("Digite o telefone: (ex.: '11 11111-1111')");
        telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        email = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        hashsenha = generateHash(senha);

        System.out.println();

        // Inicializa uma nova pessoa
        Pessoa novaPessoa = new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);

        // Pergunta se a pessoa é tutor
        System.out.print("Essa pessoa é um tutor? (s/n)\n");
        String resposta = scanner.nextLine();
        boolean ehTutor = resposta.equalsIgnoreCase("s");

        if (ehTutor) {
            System.out.print("Digite o id do Tutor: ");
            int id_tutor = scanner.nextInt();

            System.out.print("Quantos animais estão sob sua custódia? ");
            int animaisCustodia = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Digite o histórico do Tutor: ");
            String historico = scanner.nextLine();

            System.out.print("Tutor está ativo? (s/n) ");
            resposta = scanner.nextLine();
            boolean statusTutor = resposta.equalsIgnoreCase("s");

            // Cria um objeto Tutor e o adiciona à pessoa
            novaPessoa.adicionarPapel(new Tutores(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_tutor, animaisCustodia, historico, statusTutor));
        }

        // Pergunta se a pessoa é adotante
        System.out.print("Essa pessoa é um adotante? (s/n)\n");
        resposta = scanner.nextLine();

        boolean ehAdotante = resposta.equalsIgnoreCase("s");

        if (ehAdotante) {
            System.out.print("Digite o ID do adotante: ");
            int id_adotante = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha para tirar do buffer

            System.out.print("Qual a sua preferência de adoção? ");
            String preferenciaAdocao = scanner.nextLine();

            System.out.print("Digite o histórico das adoções: ");
            String historicoAdocao = scanner.nextLine();

            System.out.print("O adotante está ativo? (s/n)");
            resposta = scanner.nextLine();

            boolean statusAdotante = resposta.equalsIgnoreCase("s");

            // Adiciona os dados do Adotante
            novaPessoa.adicionarPapel(new Adotante(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_adotante, preferenciaAdocao, historicoAdocao, statusAdotante));
        }

        // Pergunta se a pessoa é funcionário
        System.out.print("Essa pessoa é um funcionário? (s/n)\n");
        resposta = scanner.nextLine();

        boolean ehFuncionario = resposta.equalsIgnoreCase("s");

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
            novaPessoa.adicionarPapel(new Funcionarios(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha, id_funcionario, dataContratacao, cargo, salario, departamento));
        }

        // Adiciona a nova pessoa na lista de pessoas
        listaPessoas.add(novaPessoa);
        return novaPessoa;
    }

    public static void VisualizarDadosPessoa() {
        for (Pessoa pessoa : listaPessoas) {
            System.out.println("---- Pessoas ----");
            System.out.println(pessoa);

            for (Papel papel : pessoa.getPapeis()) {
                papel.exibirDetalhes();
            }
        }
    }

    public static Pessoa EscolherPessoa(Scanner scanner) {

        System.out.println("---- Pessoas Cadastradas ----");

        for (int i = 0; i < listaPessoas.size(); i++) {
            Pessoa pessoa = listaPessoas.get(i);
            System.out.println((i + 1) + ". " + pessoa.getNome());
        }

        System.out.print("Escolha a pessoa que deseja editar: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha do buffer
        
        if (escolha > 0 && escolha <= listaPessoas.size()){
            Pessoa pessoaSelecionada = listaPessoas.get(escolha - 1);
            return pessoaSelecionada;
        } else {
            System.out.println("Essa pessoa não existe. Tente novamente");
            return null;
        }

        
    }

    public static void EditarPessoa(Scanner scanner, Pessoa pessoa){

        System.out.println("Editando informações de " + pessoa.getNome());
        System.out.println("Escolha o atributo que deseja editar:");
        System.out.println("1 - Nome");
        System.out.println("2 - Data de nascimento");
        System.out.println("3 - Gênero");
        System.out.println("4 - CPF");
        System.out.println("5 - Endereço (Logradouro, Número, Bairro, Cidade, Estado, País)");
        System.out.println("6 - Telefone");
        System.out.println("7 - Email");
        System.out.println("8 - Senha");
        
        // Verifica o tipo específico de pessoa (Adotante, Funcionario, Tutor)
        if (pessoa instanceof Adotante) {
            System.out.println("9 - Preferência de adoção");
            System.out.println("10 - Histórico de adoções");
            System.out.println("11 - Status");
        } else if (pessoa instanceof Funcionarios) {
            System.out.println("9 - Data de contratação");
            System.out.println("10 - Cargo");
            System.out.println("11 - Salário");
            System.out.println("12 - Departamento");
        } else if (pessoa instanceof Tutores) {
            System.out.println("9 - Animais sob custódia");
            System.out.println("10 - Histórico");
            System.out.println("11 - Status");
        }

        System.out.println("Digite o número do campo que deseja editar:");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer
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
