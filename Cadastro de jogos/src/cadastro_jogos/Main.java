/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        System.out.println("2 para Salvar");
        System.out.println("3 para listar jogos salvos no arquivo");
        System.out.println("4 para remover");
        System.out.println("5 para imprimir lista de jogos");
        System.out.println("6 para carregar arquivo");
        System.out.println("7 para buscar um jogo");
        System.out.println("8 para terminar \n");
        
        Scanner ler = new Scanner(System.in);
        
        int opcao = Integer.parseInt(ler.nextLine());
        
        while (opcao != 8) {
            switch (opcao) {
                case 1:
                    controlador.cadastraJogo();
                    break;
                case 2:
                    controlador.salvarNoArq();
                    break;
                case 3:
                    controlador.lerArquivo();
                    break;
                case 4:
                    int id = ler.nextInt();
                    controlador.removeList(id);
                    break;
                case 5:
                    controlador.imprimeList();
                    break;
                case 6:
                    controlador.CarregarArquivo();
                    break;
                case 7:
                    System.out.println("Digite o codigo do jogo:");
                    int idBusca = ler.nextInt();
                    Jogo jogo = controlador.busca(idBusca);
                    if(jogo == null) {
                        System.out.println("Codigo invalido");
                    }
                    else {
                        jogo.imprime();
                    }
                    break;
            }
            
            System.out.println(" \n Digite a opcao");
            System.out.println("1 para inserir");
            System.out.println("2 para Salvar");
            System.out.println("3 para listar jogos salvos no arquivo");
            System.out.println("4 para remover");
            System.out.println("5 imprimir a lista de jogos");
            System.out.println("6 para carregar arquivo");
            System.out.println("7 para buscar um jogo");
            System.out.println("8 para terminar \n");
        
            
            opcao = ler.nextInt();
        }
    }
}
