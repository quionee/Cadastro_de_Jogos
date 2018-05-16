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

public class Controlador {
    
    private ArrayList<JogoCartas> jogosCartas;
    private ArrayList<JogoEletronico> jogosEletronicos;
    private ArrayList<JogoTabuleiro> jogosTabuleiro;

    public Controlador() {
        this.jogosCartas = new ArrayList<JogoCartas>();
        this.jogosEletronicos = new ArrayList<JogoEletronico>();
        this.jogosTabuleiro = new ArrayList<JogoTabuleiro>();
    }

    public ArrayList<JogoCartas> getJogosCartas() {
        return jogosCartas;
    }

    public ArrayList<JogoEletronico> getJogosEletronicos() {
        return jogosEletronicos;
    }

    public ArrayList<JogoTabuleiro> getJogosTabuleiro() {
        return jogosTabuleiro;
    }
    
    private Scanner ler = new Scanner(System.in);

    void cadastraJogo(){
        System.out.println("Adicionar novo jogo");
        System.out.println("Digita o tipo do jogo carai");
        
        String tipo = ler.nextLine();// verifica qual tipo de jogo é
       // criei um if pra cada pq cada tipo tem parametros diferentes
       // criei 3 arrayList tbem um cada classe
        
        if(tipo.equals("C")){       /////////// insere um jogo de cartas 
            
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
            
            System.out.print("Quantidade de Cartas: ");
            int qtdCartas = Integer.parseInt(ler.nextLine());
            
            System.out.print("Quantidade de Jogadores : ");
            int qtdJogadores = Integer.parseInt(ler.nextLine());
            
             Jogo umJogo = new JogoCartas(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdCartas, qtdJogadores);
             System.out.println("fala galera");
             this.jogosCartas.add((JogoCartas) umJogo);
             System.out.println("coe");
        }
        else if(tipo.equals("E")){           // insere um jogo eletronico
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
            
            System.out.print("Nome da produtora: ");
            String produtora = ler.nextLine();
            
            System.out.print("Genero : ");
            String genero = ler.nextLine();
            
            Jogo umJogo = new JogoEletronico(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,produtora,genero);
            this.jogosEletronicos.add((JogoEletronico) umJogo);
        }
        else if(tipo.equals("T")){       // insere um jogo de tabuleiro
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
            
            System.out.print("Nome da Material do tabuleiro: ");
            String material = ler.nextLine();
            
            System.out.print("Quantidade de Pecas: ");
            int qtdPecas = Integer.parseInt(ler.nextLine());
            
            System.out.print("Quantidade de Jogadores : ");
            int qtdJogadores = Integer.parseInt(ler.nextLine());
            
            Jogo umJogo = new JogoTabuleiro(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,material,qtdPecas,qtdJogadores);
            this.jogosTabuleiro.add((JogoTabuleiro) umJogo);
        }
        else {
            System.out.println("TENTE NOVAMENTE");
        }

    }
    
       // mano essa funcao ta muito grande e feia... eu devo estar fazendo errado.. perguntar os cara.
    public void salvarNoArq() throws IOException {
        FileWriter arquivo = new FileWriter("cadastro_de_jogos", true);
        PrintWriter gravarArq = new PrintWriter(arquivo);
        
        for( JogoCartas jogo : this.jogosCartas ) { // insere a list dos jogos de cartas
            
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.println(jogo.getQuantidadeCartas());
            gravarArq.println(jogo.getQuantidadeJogadores());
            gravarArq.flush();
        }
         for( JogoEletronico jogo : this.jogosEletronicos ) { // insere s list dos jogos eletronicos
            
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.println(jogo.getProdutora());
            gravarArq.println(jogo.getGenero());
            gravarArq.flush();
        }
          for( JogoTabuleiro jogo : this.jogosTabuleiro ) { // insere a list dos jogos de tabuleiro
            
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.println(jogo.getMaterial());
            gravarArq.println(jogo.getQuantidadePecas());
            gravarArq.println(jogo.getQuantidadeJogadores());
            gravarArq.flush();
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
                 
        if(t.equals("C")){ // se for um jogo de cartas
   
         System.out.println(linha);
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
         linha = lerArq.readLine();
  
         System.out.println("Quantidade de Cartas:" + linha);
         linha = lerArq.readLine();
         
         System.out.println("Quantidade de Jogadores :" + linha);
         
         
         linha = lerArq.readLine(); // leitura para usar no if quando voltar
         t = linha;
        }
        else if(t.equals("E")){
               
         System.out.println(linha);
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
         linha = lerArq.readLine();
         
         System.out.println("Produtora :" + linha);
         linha = lerArq.readLine();
         
         System.out.println("Genero :" + linha);
         
         linha = lerArq.readLine(); // leitura pra usar no if quando voltar
          t = linha;
        }
        else if(t.equals("T")){
                   
         System.out.println(linha);
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
         linha = lerArq.readLine();
         
         System.out.println("AMterial do tabuleiro:" + linha);
         linha = lerArq.readLine();
         
         System.out.println("Quantidades de pecas :" + linha);
         linha = lerArq.readLine();
         
         System.out.println("Quantidades de jogadores:" + linha);
         
         linha = lerArq.readLine(); // leitura pra usar no if quando voltar
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

