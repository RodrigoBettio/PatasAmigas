package model;

import java.util.Scanner;

public interface Papel {
    void exibirDetalhes();
    void exibirDetalhesParaEscolha();
    void editarDetalhes(int opcao, Scanner scanner);
}
