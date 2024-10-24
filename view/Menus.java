package view;

import java.util.Scanner;

public class Menus {

    public static int menu(Scanner scanner, int escolha) {
        // mostra o menu
        System.out.println();
        System.out.println("---- Menu ----");
        System.out.println("1. Página de Cadastro");
        System.out.println("2. Editar pessoas cadastradas");
        System.out.println("3. Visualizar pessoas cadastradas");;
        System.out.println("4. Buscar");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        return escolha;
    }

    public static int MenuCadastro(Scanner scanner, int escolhaCadastro){
        System.out.println("Deseja cadastrar");
        System.out.println("1- Pessoa");
        System.out.println("2- Animal");

        escolhaCadastro = scanner.nextInt();
        scanner.nextLine();

        return escolhaCadastro;
    }

}
