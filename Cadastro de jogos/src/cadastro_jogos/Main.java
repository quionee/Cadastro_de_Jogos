/*
   Trabalho de Paradigmas de Linguagens de Programacao
   Cadastro de Jogos
   Copyright 2018 by Lorena Tavares, Rodrigo Herculano, William Coelho
   Arquivo responsavel pela iteracao com o usuario
*/

package cadastro_jogos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Controlador controlador = new Controlador();
  
        System.out.println("Digite a opcao");
        System.out.println("1 para inserir");
        System.out.println("2 para remover");
        System.out.println("3 para buscar um jogo");
        System.out.println("4 para carregar arquivo na memoria");
        System.out.println("5 para listar jogos da memoria");
        System.out.println("6 para listar jogos do arquivo");
        System.out.println("7 para salvar memoria no arquivo");
        System.out.println("8 para terminar \n");
        
        Scanner ler = new Scanner(System.in);
        
        int opcao = Integer.parseInt(ler.nextLine());
        
        System.out.println();
        while (opcao != 8) {
            switch (opcao) {
                case 1:
                    controlador.cadastraJogo();
                    break;
                case 2:
                    System.out.print("Insira o codigo do jogo a ser removido: ");
                    int id = ler.nextInt();
                    controlador.removeList(id);
                    break;
                case 3:
                    System.out.print("Digite o codigo do jogo a ser buscado: ");
                    int idBusca = ler.nextInt();
                    Jogo jogo = controlador.busca(idBusca);
                    if (jogo == null) {
                        System.out.println("\nCodigo invalido");
                    }
                    else {
                        jogo.imprime();
                    }
                    break;
                case 4:
                    controlador.CarregarArquivo();
                    break;
                case 5:
                    controlador.imprimeList();
                    break;
                case 6:
                    controlador.lerArquivo();
                    break;
                case 7:
                    controlador.salvarNoArq();
                    break;
                default:
                    System.out.println("\nOpcao invalida, tente novamente!\n");
                    break;
            }

            System.out.println("\nDigite a opcao");
            System.out.println("1 para inserir");
            System.out.println("2 para remover");
            System.out.println("3 para buscar um jogo");
            System.out.println("4 para carregar arquivo na memoria");
            System.out.println("5 para listar jogos da memoria");
            System.out.println("6 para listar jogos do arquivo");
            System.out.println("7 para salvar memoria no arquivo");
            System.out.println("8 para terminar \n");
        
            opcao = ler.nextInt();
            System.out.println();
        }
        System.out.println("\nPrograma encerrado!\n");
    }
}
