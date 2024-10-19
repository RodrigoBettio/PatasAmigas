package controllers;

import java.util.Scanner;

import controllers.PessoaController;
import model.Pessoa;

public class FiltroController {
    
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
                filtrarPessoa(scanner);
                break;
            case 2:
                filtrarAnimal(scanner);
                break;
            default:
            System.out.println("Opção inválida!");
            buscaPorFiltro(scanner);
                break;
        }
    }

    public static void filtrarPessoa(Scanner scanner){

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

    
    public static String filtrarAnimal(Scanner scanner){

        System.out.println("Qual é a especie do animal?");
        //String escolhaEspecie = scanner.nextLine();

        String resultadoBusca = "oie";

        return resultadoBusca;
    }   

}
