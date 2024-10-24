package view;

import controllers.*;
import java.util.Scanner;

public class FiltroView {

    public static void buscaPorFiltro(Scanner scanner) {

        System.out.println();
        System.out.println("O que você quer buscar?\n");
        System.out.println("1. Pessoa");
        System.out.println("2. Animal\n");
        System.out.print("Escolha uma opção: ");
        Integer opcaoBusca = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoBusca) {
            case 1:
                PessoaController.filtrarPessoa(scanner);
                break;
            case 2:
                AnimalController.filtrarAnimal(scanner);
                break;
            default:
            System.out.println("Opção inválida!");
            buscaPorFiltro(scanner);
                break;
        }
    }
    
}


