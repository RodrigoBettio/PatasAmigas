package controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import model.Animal;

public class AnimalController {

    private static ArrayList<Animal> listaAnimais = new ArrayList<>();

    public static Animal CadastrarAnimal(Scanner scanner) {

        String nome, especie, historico, tutor;
        Integer id, idade;
        boolean statusAdocao;

        System.out.println("Qual é o ID do animal?");
        id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("\nQual é o nome do animal?");
        nome = scanner.nextLine();

        System.out.println("\nE de que espécie ele é?");
        especie = scanner.nextLine();

        System.out.println("\nVocê sabe a idade dele? (digite sim ou não)");
        String resposta = scanner.nextLine();
        boolean sabeIdade = resposta.equalsIgnoreCase("sim");

        if (sabeIdade) {
            System.out.println("\nCerto, digite aqui a idade do animal: (apenas números)");
            idade = scanner.nextInt();
            scanner.nextLine();
        } else {
            System.out.println("\nTudo certo! Vamos pular essa etapa.");
            scanner.nextLine();
            idade = null;
        }

        System.out.println("\nJá estamos finalizando! Mas precisamos saber do histórico do animal, você tem conhecimento?\nDigite sua resposta:");  
        historico = scanner.nextLine();

        System.out.println("\nPor último, ele está sob a tutoria de quem? \nDigite o nome da pessoa:" );
        tutor = scanner.nextLine();

        statusAdocao = false;

        Animal novoAnimal = new Animal(id, idade, nome, especie, historico, statusAdocao, tutor);

        listaAnimais.add(novoAnimal);
        return novoAnimal;
    }

    public static void FiltrarAnimal(Scanner scanner) {
        int escolha;

        System.out.println("Desejar filtrar por: ");
        System.out.println("1 - Espécie");
        System.out.println("2 - Idade");
        escolha = scanner.nextInt();
        
        switch (escolha) {
            case 1:
                FiltroEspecie(scanner);
                break;
        
            default:
            FiltroIdade(scanner);
                break;
        }
    }

    public static void FiltroEspecie(Scanner scanner){
        System.out.println("Qual é a especie do animal?");
        String escolhaEspecie = scanner.nextLine();
       
        List<Animal> animaisEncontrados = listaAnimais.stream()
        .filter(a -> a.getEspecie().equalsIgnoreCase(escolhaEspecie))
        .collect(Collectors.toList());

        if(animaisEncontrados != null){
            System.out.println("Animais dessa espécie encontrados: \n" );
            animaisEncontrados.forEach(animal -> System.out.println(animal));
        } else {
            System.out.println("Nenhum animal da espécie " + escolhaEspecie + " foi encontrado!");
        }
    }

    public static void FiltroIdade(Scanner scanner){
        System.out.println("Qual é a idade do animal?");
        int escolhaIdade = scanner.nextInt();
       
        List<Animal> animaisEncontrados = listaAnimais.stream()
        .filter(a -> a.getIdade().equals(escolhaIdade))
        .collect(Collectors.toList());

        if(animaisEncontrados != null){
            System.out.println("Animais com essa idade foram encontrados: \n" );
            animaisEncontrados.forEach(animal -> System.out.println(animal));
        } else {
            System.out.println("Nenhum animal da idade: " + escolhaIdade + ", foi encontrado!");
        }

    }
}
