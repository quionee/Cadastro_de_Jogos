/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;

import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Main {
    
    private Scanner ler = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    private void cadastraJogo(){
        System.out.println("Adicionar novo jogo");
        System.out.print("Codigo: ");
        int codigo = ler.nextInt();
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Faixa etaria: ");
        int faixaEtaria = ler.nextInt();
        System.out.print("Popularidade: ");
        int popularidade = ler.nextInt();
        Jogo umJogo = new Jogo(codigo, nome, faixaEtaria, popularidade);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        
    }

    
    
}
