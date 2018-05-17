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
           
        Controlador cont = new Controlador();
  
        System.out.println("Digite a opcao");
        System.out.println("1 para inserir");
        System.out.println("2 para Salvar");
        System.out.println("3 para listar jogos");
        System.out.println("4 para terminar");
        
        Scanner ler = new Scanner(System.in);
        
        int opcao = Integer.parseInt(ler.nextLine());
        
        while(opcao != 4){
            
            switch(opcao){
                case 1:
                    cont.cadastraJogo();
                break;  
                
                case 2:
                    cont.salvarNoArq();
                break;
                case 3:
                    cont.lerArquivo();
                break;
            }
            
            System.out.println("Digite a opcao");
            System.out.println("1 para inserir");
            System.out.println("2 para Salvar");
            System.out.println("3 para listar jogos");
            System.out.println("4 para terminar");
            opcao = ler.nextInt();
        }
    }
}
