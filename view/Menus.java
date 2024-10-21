package view;

import java.util.Scanner;

public class Menus {

    public static int menu(Scanner scanner, int escolha) {
        // mostra o menu
        System.out.println();
        System.out.println("---- Menu ----");
        System.out.println("1. Cadastrar pessoa");
        System.out.println("2. Editar pessoas cadastradas");
        System.out.println("3. Visualizar pessoas cadastradas");
        System.out.println("4. Cadastrar um animal");
        System.out.println("5. Buscar");
        System.out.println("6. Sair");
        System.out.print("Escolha uma opção: ");
        escolha = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha para tirar do buffer

        return escolha;
    }

}
