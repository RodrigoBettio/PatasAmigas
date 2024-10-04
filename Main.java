
import heranca.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Cadastrar pessoa");
            System.out.println("2. Visualizar pessoas cadastradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

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
        return new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone, email, hashsenha);
    }

    public static void VisualizarPessoa(){
        System.out.println("Olá");
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
