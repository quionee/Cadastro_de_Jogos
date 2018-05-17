/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class Controlador {
    
      //private ArrayList<JogoCartas> jogosCartas;
     // private ArrayList<JogoEletronico> jogosEletronicos;
     // private ArrayList<JogoTabuleiro> jogosTabuleiro;
      private ArrayList<Jogo> lista;

    public Controlador() {

        this.lista = new ArrayList<Jogo>();
    }

    private Scanner ler = new Scanner(System.in);

    void cadastraJogo(){
        System.out.println("Adicionar novo jogo");
        System.out.println("Digita o tipo do jogo carai");
        
        String tipo = ler.nextLine();// verifica qual tipo de jogo é
       // criei um if pra cada pq cada tipo tem parametros diferentes
       // criei 3 arrayList tbem um cada classe
        if(tipo.equals("C") || tipo.equals("T") || tipo.equals("E") ){
                        
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
            
            if(tipo.equals("C")){       /////////// insere um jogo de cartas 

                System.out.print("Quantidade de Cartas: ");
                int qtdCartas = Integer.parseInt(ler.nextLine());

                System.out.print("Quantidade de Jogadores : ");
                int qtdJogadores = Integer.parseInt(ler.nextLine());

                 Jogo umJogo = new JogoCartas(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdCartas, qtdJogadores);
                 System.out.println("fala galera");
                // this.jogosCartas.add((JogoCartas) umJogo);
                 this.lista.add(umJogo);
            }
            else if(tipo.equals("E")){           // insere um jogo eletronico
   
                System.out.print("Nome da produtora: ");
                String produtora = ler.nextLine();

                System.out.print("Genero : ");
                String genero = ler.nextLine();

                Jogo umJogo = new JogoEletronico(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,produtora,genero);
                this.lista.add(umJogo);
            }
            else if(tipo.equals("T")){       // insere um jogo de tabuleiro
         
                System.out.print("Nome da Material do tabuleiro: ");
                String material = ler.nextLine();

                System.out.print("Quantidade de Pecas: ");
                int qtdPecas = Integer.parseInt(ler.nextLine());

                System.out.print("Quantidade de Jogadores : ");
                int qtdJogadores = Integer.parseInt(ler.nextLine());

                Jogo umJogo = new JogoTabuleiro(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,material,qtdPecas,qtdJogadores);

                this.lista.add(umJogo);
            }
        }
                
        else {
            System.out.println("TENTE NOVAMENTE");
        }

    }
    
       // mano essa funcao ta muito grande e feia... eu devo estar fazendo errado.. perguntar os cara.
    public void salvarNoArq() throws IOException {
        FileWriter arquivo = new FileWriter("cadastro_de_jogos", true);
        PrintWriter gravarArq = new PrintWriter(arquivo);
 
          for(Jogo jogo : this.lista){
              
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            
            if(jogo instanceof JogoCartas){
                
                gravarArq.println(((JogoCartas)jogo).getQuantidadeCartas());
                gravarArq.println(((JogoCartas)jogo).getQuantidadeJogadores());
                gravarArq.flush();
            }
            else if(jogo instanceof JogoTabuleiro){

                gravarArq.println(((JogoTabuleiro)jogo).getMaterial());
                gravarArq.println(((JogoTabuleiro)jogo).getQuantidadePecas());
                gravarArq.println(((JogoTabuleiro)jogo).getQuantidadeJogadores());
                gravarArq.flush();
            }
            else if(jogo instanceof JogoEletronico){
                
                gravarArq.println(((JogoEletronico)jogo).getProdutora());
                gravarArq.println(((JogoEletronico)jogo).getGenero());
                gravarArq.flush();
            }
        }

    }
    
    public void lerArquivo(){
        
      try {
      FileReader arq = new FileReader("cadastro_de_jogos");
      BufferedReader lerArq = new BufferedReader(arq);
 
      String linha = lerArq.readLine(); // lê a primeira linha
// a variável "linha" recebe o valor "null" quando o processo
// de repetição atingir o final do arquivo texto
      String t = linha;
      while (linha != null) {
        
        System.out.println(t);
        if(t.equals("C") || t.equals("T") || t.equals("E") ){
            
         linha = lerArq.readLine();
         System.out.println("Codigo do Jogo :" + linha);
         
         linha = lerArq.readLine();
         System.out.println("Nome :" + linha);
         
         linha = lerArq.readLine();
         System.out.println("Faixa Etaria :" + linha);
         
         linha = lerArq.readLine();
         System.out.println("Popularidade:" + linha);
         
         linha = lerArq.readLine();
         System.out.println("Ano de Lancamento :" + linha);
         
            if(t.equals("C")){ // se for um jogo de cartas

             linha = lerArq.readLine();
             System.out.println("Quantidade de Cartas:" + linha);
             
             linha = lerArq.readLine();
             System.out.println("Quantidade de Jogadores :" + linha);
             System.out.println();
             
            }
            else if(t.equals("E")){
                
            linha = lerArq.readLine();
             System.out.println("Produtora :" + linha);
             
             linha = lerArq.readLine();
             System.out.println("Genero :" + linha);
             System.out.println();

            }
            else if(t.equals("T")){
                
             linha = lerArq.readLine();
             System.out.println("AMterial do tabuleiro:" + linha);
             
             linha = lerArq.readLine();
             System.out.println("Quantidades de pecas :" + linha);
             
             linha = lerArq.readLine();
             System.out.println("Quantidades de jogadores:" + linha);
             System.out.println();
            }
            
            linha = lerArq.readLine();
            t = linha;
          }
      }
        arq.close();
    } catch (IOException e) {
        System.err.printf("Erro na abertura do arquivo: %s.\n",
          e.getMessage());
    }
 
    System.out.println();
  }
    
    public void remove(){
        
        // minha ideia é jogar o arquivo todo nas 3 lists aux sem o item que eu quero remover
        // e depois inserir novamente tudo no arquivo apos truncar tuco
        // deu preguica de acabar a funcao
        System.out.println("Digite o id do jogo para ser deletado  :");
        int id = Integer.parseInt(ler.nextLine());
        
        ArrayList<JogoCartas> jogosCartasAux = new ArrayList<JogoCartas>();
        ArrayList<JogoEletronico> jogosEletronicosAux = new ArrayList<JogoEletronico>();
        ArrayList<JogoTabuleiro> jogosTabuleiroAux = new ArrayList<JogoTabuleiro>();
    }
}

