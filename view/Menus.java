package view;

import java.util.Scanner;

public class Menus {

    public static int menuPrincipal(Scanner scanner, int escolha) {
        // mostra o menu
        System.out.println();
        System.out.println("---- Menu ----");
        System.out.println("1. Página de Cadastro");
        System.out.println("2. Editar pessoas cadastradas");
        System.out.println("3. Página de Visualização");;
        System.out.println("4. Buscar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        return escolha;
    }

    public static int menuCadastro(Scanner scanner, int escolhaCadastro){
        System.out.println("Deseja cadastrar");
        System.out.println("1- Pessoa");
        System.out.println("2- Animal");

        escolhaCadastro = scanner.nextInt();
        scanner.nextLine();

        return escolhaCadastro;
    }

    public static int menuVisualizacao(Scanner scanner, int escolhaVisualizacao){
        System.out.println("Deseja visualizar");
        System.out.println("1- Pessoa");
        System.out.println("2- Animal");

        escolhaVisualizacao = scanner.nextInt();
        scanner.nextLine();

        return escolhaVisualizacao;
    }

}
