/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Controlador {
    
    private ArrayList<Jogo> listaDeJogos;
    
    private Scanner ler = new Scanner(System.in);

    void cadastraJogo(){
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
        this.listaDeJogos.add(umJogo);
       
    }
    
    void leJogo() throws FileNotFoundException {
        
        FileReader arq = new FileReader("cadastro_de_jogos");
        BufferedReader learq = new BufferedReader(arq);
        
        
        Jogo umJogo = new Jogo(codigo, nome, faixaEtaria, popularidade, anoLancamento);
        
        
    }

    public Controlador() {
        this.listaDeJogos = new ArrayList<Jogo>();
    }

    public void salvarNoArq() throws IOException {
        FileWriter arquivo = new FileWriter("cadastro_de_jogos", true);
        PrintWriter gravarArq = new PrintWriter(arquivo);
       
        for( Jogo jogo : this.listaDeJogos ) {
            
            gravarArq.print(jogo.getCodigo() + " ; ");
            gravarArq.print(jogo.getNome() + " ; ");
            gravarArq.print(jogo.getFaixaEtaria() + " ; ");
            gravarArq.print(jogo.getPopularidade() + " ; ");
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.flush();
        }
    }
    
    public void imprime()
    
}
