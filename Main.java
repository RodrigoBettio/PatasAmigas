
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Pessoa novapessoa = cadastro_pessoa();
        novapessoa.ToString();
    }

    public static Pessoa cadastro_pessoa() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite a data de nascimento: ");
        String nascimento = scanner.nextLine();

        System.out.println("Digite o gênero : ('M' para masculino, 'F' para feminino e 'O' para outros)");
        String genero = scanner.nextLine();

        System.out.println("Digite o CPF: (ex.: 123.123.123-12)");
        String CPF = scanner.nextLine();

        System.out.print("Digite o logradouro: ");
        String logradouro = scanner.nextLine();

        System.out.print("Digite o número: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o bairro: ");
        String bairro = scanner.nextLine();

        System.out.print("Digite a cidade: ");
        String cidade = scanner.nextLine();

        System.out.print("Digite o estado: ");
        String estado = scanner.nextLine();

        System.out.print("Digite o país: ");
        String pais = scanner.nextLine();

        System.out.println("Digite o telefone: (ex.: '11 11111-1111')");
        String telefone = scanner.nextLine();

        System.out.print("Digite o email: ");
        String email = scanner.nextLine();

        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();

        String hashsenha = generateHash(senha);

        return new Pessoa(nome, nascimento, genero, CPF, logradouro, numero, bairro, cidade, estado, pais, telefone,
                email, hashsenha);

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
