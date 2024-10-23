package controllers;

import com.sun.tools.javac.Main;
import funcoes_compartilhadas.Funcoes;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Adotante;
import model.Funcionarios;
import model.HistoricoAdotante;
import model.Papel;
import model.Pessoa;
import model.Tutores;

public class PessoaController {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();

    public static Pessoa CadastrarPessoa(Scanner scanner) {

        String nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email,
                hashsenha;

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
        hashsenha = Funcoes.generateHash(senha);

        System.out.println();

        // Inicializa uma nova pessoa
        Pessoa novaPessoa = new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais,
                telefone, email, hashsenha);

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
            String historico_tutor = scanner.nextLine();

            System.out.print("Tutor está ativo? (s/n) ");
            resposta = scanner.nextLine();
            boolean statusTutor = resposta.equalsIgnoreCase("s");

            // Cria um objeto Tutor e o adiciona à pessoa
            novaPessoa.adicionarPapel(new Tutores(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade,
                    estado, pais, telefone, email, hashsenha, id_tutor, animaisCustodia, historico_tutor, statusTutor));
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

            System.out.print("Digite a descrição do histórico: ");
            String descricaoHistorico = scanner.nextLine();

            System.out.print("Digite o número de adoções: ");
            int numeroAdocoes = Integer.parseInt(scanner.nextLine());

            System.out.print("O adotante está ativo? (s/n)");
            resposta = scanner.nextLine();

            boolean statusAdotante = resposta.equalsIgnoreCase("s");

            // Adiciona os dados do histórico
            HistoricoAdotante historico_adotante = new HistoricoAdotante(descricaoHistorico, numeroAdocoes);
            // Adiciona os dados do Adotante
            novaPessoa.adicionarPapel(new Adotante(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade,
                    estado, pais, telefone, email, hashsenha, id_adotante, preferenciaAdocao, historico_adotante,
                    statusAdotante));
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
            novaPessoa.adicionarPapel(
                    new Funcionarios(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais,
                            telefone, email, hashsenha, id_funcionario, dataContratacao, cargo, salario, departamento));
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

        if (escolha > 0 && escolha <= listaPessoas.size()) {
            Pessoa pessoaSelecionada = listaPessoas.get(escolha - 1);
            return pessoaSelecionada;
        } else {
            System.out.println("Essa pessoa não existe. Tente novamente");
            return null;
        }

    }

    public static void EditarPessoa(Scanner scanner, Pessoa pessoa) {

        System.out.println();
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

        for (Papel papel : pessoa.getPapeis()) {
            papel.exibirDetalhesParaEscolha();
        }

        System.out.println("Digite o número do campo que deseja editar:");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        switch (opcao) {

            case 1:
                System.out.println("Digite o novo nome: ");
                String novoNome = scanner.nextLine();
                pessoa.setNome(novoNome);
                break;

            case 2:
                System.out.println("Digite a nova data de nascimento:");
                String novaData = scanner.nextLine();
                pessoa.setNascimento(novaData);
                break;

            case 3:
                System.out.println("Digite o novo gênero:");
                String novoGenero = scanner.nextLine();
                pessoa.setGenero(novoGenero);
                break;

            case 4:
                System.out.println("Digite o novo CPF:");
                String novoCPF = scanner.nextLine();
                pessoa.setCPF(novoCPF);
                break;

            case 5:
                System.out.println("Digite o novo logradouro:");
                String logradouro = scanner.nextLine();
                pessoa.setLogradouro(logradouro);

                System.out.println("Digite o novo número:");
                String numero = scanner.nextLine();
                pessoa.setNumero(numero);

                System.out.println("Digite o novo bairro:");
                String bairro = scanner.nextLine();
                pessoa.setBairro(bairro);

                System.out.println("Digite a nova cidade:");
                String cidade = scanner.nextLine();
                pessoa.setCidade(cidade);

                System.out.println("Digite o novo estado:");
                String estado = scanner.nextLine();
                pessoa.setEstado(estado);

                System.out.println("Digite o novo país:");
                String pais = scanner.nextLine();
                pessoa.setPais(pais);
                break;

            case 6:
                System.out.println("Digite o novo telefone:");
                String telefone = scanner.nextLine();
                pessoa.setTelefone(telefone);
                break;

            case 7:
                System.out.println("Digite o novo email:");
                String email = scanner.nextLine();
                pessoa.setEmail(email);
                break;

            case 8:
                System.out.println("Digite a nova senha:");
                String novaSenha = scanner.nextLine();
                pessoa.setHashsenha(novaSenha);
                break;

            case 9: 
            case 10:
            case 11:
                System.out.println("Escolha o papel que deseja editar:");
                List<Papel> papeis = pessoa.getPapeis();
                for (int i = 0; i < papeis.size(); i++) {
                    System.out.println((i + 1) + " - " + papeis.get(i).getClass().getSimpleName()); 
                    //Percorre a lista de papéis e usa os métodos getClass() e getSimpleName() para pegar o nome da classe e retornar em string para facilitar a leitura
                }

                int escolhaPapel = scanner.nextInt() - 1; 
                scanner.nextLine(); // Consumir a nova linha

                if (escolhaPapel >= 0 && escolhaPapel < papeis.size()) {
                    Papel papelSelecionado = papeis.get(escolhaPapel);
                    papelSelecionado.editarDetalhes(opcao, scanner);
                } else {
                    System.out.println("Opção de papel inválida!");
                }
                break;

            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    public static void FiltrarPessoa(Scanner scanner) {

        System.out.println("Digite um nome para buscar: ");
        String escolhaNome = scanner.nextLine();

        // Filtra a lista de pessoas pelo nome
        Pessoa pessoaEncontrada = listaPessoas.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(escolhaNome))
                .findFirst()
                .orElse(null);

        // Verifica se a pessoa foi encontrada
        if (pessoaEncontrada != null) {
            System.out.println("Pessoa encontrada: \n\n" + pessoaEncontrada);
        } else {
            System.out.println("Nenhuma pessoa com o nome '" + escolhaNome + "' foi encontrada.");
        }
    }
}
