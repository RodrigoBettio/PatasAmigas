package view;

import controllers.*;
import java.util.Scanner;

public class FiltroView {

    public static void BuscaPorFiltro(Scanner scanner) {

        System.out.println();
        System.out.println("O que você quer buscar?\n");
        System.out.println("1. Pessoa");
        System.out.println("2. Animal\n");
        System.out.print("Escolha uma opção: ");
        Integer opcaoBusca = scanner.nextInt();
        scanner.nextLine();

        switch (opcaoBusca) {
            case 1:
                PessoaController.FiltrarPessoa(scanner);
                break;
            case 2:
                AnimalController.FiltrarAnimal(scanner);
                break;
            default:
            System.out.println("Opção inválida!");
            BuscaPorFiltro(scanner);
                break;
        }
    }
    
}


