
import controllers.*;
import model.*;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        // Exibe o menu somente até o momento em que o usuário escolhe a opção 'Sair'
        do {
            menu(scanner, escolha);

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
                    EditarPessoa(scanner, pessoa);
                    System.out.println("Pessoa editada com sucesso!");
                    break;
    
                case 3:
                    System.out.println();
                    VisualizarDadosPessoa();
                    break;
    
                case 4:
                    buscaPorFiltro(scanner);
                    break;
    
                case 5:
                    System.out.println("Saindo...");
                    break;
    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
           
        } while (escolha != 5);
        scanner.close();
    }

    public static int menu(Scanner scanner, int escolha){
        //mostra o menu
        System.out.println();
        System.out.println("---- Menu ----");
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Editar pessoas cadastradas");
        System.out.println("3. Visualizar pessoas cadastradas");
        System.out.println("4. Buscar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        return escolha;
    }
   
}
