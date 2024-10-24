
import controllers.*;
import java.util.Scanner;
import model.*;
import view.FiltroView;
import view.Menus;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha = 0;

        // Exibe o menu somente até o momento em que o usuário escolhe a opção 'Sair'
        do {
            escolha = Menus.menu(scanner, escolha);

            switch (escolha) {
                case 1:
                    int escolhaCadastro = 0;
                    System.out.println();
                    escolhaCadastro = Menus.MenuCadastro(scanner, escolhaCadastro);

                    switch (escolhaCadastro) {
                        case 1:
                            PessoaController.CadastrarPessoa(scanner);
                            System.out.println("Pessoa cadastrada com sucesso!");
                            break;
                        case 2:
                            System.out.println();
                            AnimalController.CadastrarAnimal(scanner);
                            System.out.println("\nAnimal cadastrado com sucesso!!!");
                            break;

                        default:
                            System.out.println("Opção Inválida");
                            break;
                    }
                    break;

                case 2:
                    System.out.println();
                    Pessoa pessoa = PessoaController.EscolherPessoa(scanner);
                    if (pessoa != null) {
                        PessoaController.EditarPessoa(scanner, pessoa);
                        System.out.println("Pessoa editada com sucesso!");
                    }
                    break;
                case 3:
                    System.out.println();
                    PessoaController.VisualizarDadosPessoa(scanner);
                    break;
                case 4:
                    FiltroView.BuscaPorFiltro(scanner);
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

}
