/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Controlador {
    
    private Scanner ler = new Scanner(System.in);

    void cadastraJogo() throws IOException {
        System.out.println("Adicionar novo jogo");
        System.out.print("Codigo: ");
        int codigo = Integer.parseInt(ler.nextLine());
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("Faixa etaria: ");
        int faixaEtaria = Integer.parseInt(ler.nextLine());
        System.out.print("Popularidade: ");
        int popularidade = Integer.parseInt(ler.nextLine());
        System.out.print("Ano de Lancamento: ");
        int anoLancamento = Integer.parseInt(ler.nextLine());
        Jogo umJogo = new Jogo(codigo, nome, faixaEtaria, popularidade, anoLancamento);
        FileWriter arquivo = new FileWriter("cadastro_de_jogos");
        PrintWriter gravarArq = new PrintWriter(arquivo);
        gravarArq.println(umJogo);
        gravarArq.close();
    }

    public Controlador() {
    }
    
    
}
