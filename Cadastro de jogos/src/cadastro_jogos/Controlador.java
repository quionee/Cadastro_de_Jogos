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
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.Query.not;

public class Controlador {
    
      //private ArrayList<JogoCartas> jogosCartas;
     // private ArrayList<JogoEletronico> jogosEletronicos;
     // private ArrayList<JogoTabuleiro> jogosTabuleiro;
      private ArrayList<Jogo> lista;

    public Controlador() {
        this.lista = new ArrayList<Jogo>();
    }

    private Scanner ler = new Scanner(System.in);

    void cadastraJogo() {
        System.out.println("Adicionar novo jogo");
        System.out.println("Digite o tipo do jogo\n -T (tabuleiro)\n -C (cartas)\n -E (eletronico)\n" );
        
        String tipo = ler.nextLine();// verifica qual tipo de jogo é
        // criei um if pra cada pq cada tipo tem parametros diferentes
        // criei 3 arrayList tbem um cada classe
        if (tipo.equals("C") || tipo.equals("T") || tipo.equals("E") ) {
                        
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
   
            System.out.print("Quantidade de Jogadores: ");
            int qtdJogadores = Integer.parseInt(ler.nextLine());
            
            System.out.println("O jogo possui uma produtora conhecida?\n -1: Sim\n -2: Nao\n");
            int opcao = Integer.parseInt(ler.nextLine());
            if (opcao == 1) {
                System.out.print("Produtora: \n");
                System.out.print("CNPJ: ");
                String cnpj = ler.nextLine();

                System.out.print("Nome: ");
                String nomeP = ler.nextLine();

                Produtora produtora = new Produtora(cnpj,nomeP);
            
                if (tipo.equals("C")) {       /////////// insere um jogo de cartas 

                    System.out.print("Quantidade de Cartas: ");
                    int qtdCartas = Integer.parseInt(ler.nextLine());

                    System.out.print("Material do baralho: ");
                    String materialBaralho = ler.nextLine();
                    Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                    // this.jogosCartas.add((JogoCartas) umJogo);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("E")) {           // insere um jogo eletronico

                    System.out.print("Genero: ");
                    String genero = ler.nextLine();
                    String console = ler.nextLine();
                    Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("T")) {       // insere um jogo de tabuleiro

                    System.out.print("Material do tabuleiro: ");
                    String material = ler.nextLine();

                    System.out.print("Quantidade de Pecas: ");
                    int qtdPecas = Integer.parseInt(ler.nextLine());

                    Jogo umJogo = new JogoTabuleiro(material,qtdPecas, tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);

                    this.lista.add(umJogo);
                }
            }
            else if (opcao == 2) {
                if (tipo.equals("C")) {       /////////// insere um jogo de cartas 
                    System.out.print("Quantidade de Cartas: ");
                    int qtdCartas = Integer.parseInt(ler.nextLine());

                    System.out.print("Material do baralho: ");
                    String materialBaralho = ler.nextLine();
                    Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores);
                    // this.jogosCartas.add((JogoCartas) umJogo);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("E")) {           // insere um jogo eletronico

                    System.out.print("Genero: ");
                    String genero = ler.nextLine();
                    String console = ler.nextLine();
                    Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("T")) {       // insere um jogo de tabuleiro

                    System.out.print("Material do tabuleiro: ");
                    String material = ler.nextLine();

                    System.out.print("Quantidade de Pecas: ");
                    int qtdPecas = Integer.parseInt(ler.nextLine());

                    Jogo umJogo = new JogoTabuleiro(material,qtdPecas, tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores);

                    this.lista.add(umJogo);
                }
            }
        }    
        else {
            System.out.println("TENTE NOVAMENTE \n");
        }
    }
    
    public void salvarNoArq() throws IOException {
        FileWriter arquivo = new FileWriter("cadastro_de_jogos", false);
        PrintWriter gravarArq = new PrintWriter(arquivo);
 
          for(Jogo jogo : this.lista) { 
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.println(jogo.getQuantidadeJogadores());
            gravarArq.println(jogo.produtora.getCnpj());
            gravarArq.println(jogo.produtora.getNome());
            
            if (jogo instanceof JogoCartas) {  
                gravarArq.println(((JogoCartas)jogo).getQuantidadeCartas());
                gravarArq.println(((JogoCartas)jogo).getMaterialBaralho());
                System.out.println(((JogoCartas)jogo).getMaterialBaralho());
            }
            else if (jogo instanceof JogoTabuleiro) {
                gravarArq.println(((JogoTabuleiro)jogo).getMaterial());
                gravarArq.println(((JogoTabuleiro)jogo).getQuantidadePecas());;
            }
            else if (jogo instanceof JogoEletronico) {
                gravarArq.println(((JogoEletronico)jogo).getGenero());
                gravarArq.println(((JogoEletronico)jogo).getConsole());
            }
        }
            gravarArq.flush();
    }
    
    public void CarregarArquivo() throws IOException {
 
        try {
            FileReader arq = new FileReader("cadastro_de_jogos");
            BufferedReader lerArq = new BufferedReader(arq);
            String linha = lerArq.readLine();
            if(linha == null) {
                System.out.println("Arquivo vazio \n");
            }
            else {
                String tipo = linha;
                while (linha != null) {
                    if (tipo.equals("C") || tipo.equals("T") || tipo.equals("E")) {
                        int codigo = Integer.parseInt(lerArq.readLine());
                        String nome = lerArq.readLine();
                        int faixaEtaria = Integer.parseInt(lerArq.readLine());
                        int popularidade = Integer.parseInt(lerArq.readLine());
                        int anoLancamento = Integer.parseInt(lerArq.readLine());
                        int qtdJogadores = Integer.parseInt(lerArq.readLine());
                        String cnpj = lerArq.readLine();
                        String nomeP = lerArq.readLine();
                       
                        Produtora produtora = new Produtora(cnpj,nomeP);
                        if (tipo.equals("C")) { // se for um jogo de cartas
                            int qtdCartas = Integer.parseInt(lerArq.readLine());
                            String materialBaralho = lerArq.readLine();
                            Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoCartas)umJogo);
                        }
                        else if (tipo.equals("E")) {
                            String genero = lerArq.readLine();
                            String console = lerArq.readLine();
                            Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoEletronico)umJogo);
                        }
                        else if (tipo.equals("T")) {
                            String material = lerArq.readLine();
                            int qtdPecas = Integer.parseInt(lerArq.readLine());
                            Jogo umJogo = new JogoTabuleiro(material,qtdPecas,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoTabuleiro)umJogo);
                        }
                        linha = lerArq.readLine();
                        tipo = linha;
                    }
                }
                arq.close();
            }
        }
        catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void lerArquivo() {
        try {
            FileReader arq = new FileReader("cadastro_de_jogos");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto
            if (linha == null) {
                System.out.println("Arquivo vazio \n");
            }
            else {
                String t = linha;
                while (linha != null) {
                    System.out.println(t);
                    if (t.equals("C") || t.equals("T") || t.equals("E") ) {
                        linha = lerArq.readLine();
                        System.out.println("Codigo do Jogo: " + linha);

                        linha = lerArq.readLine();
                        System.out.println("Nome: " + linha);

                        linha = lerArq.readLine();
                        System.out.println("Faixa Etaria: " + linha);

                        linha = lerArq.readLine();
                        System.out.println("Popularidade: " + linha);

                        linha = lerArq.readLine();
                        System.out.println("Ano de Lancamento: " + linha);
                        
                        linha = lerArq.readLine();
                        System.out.println("Quantidade de Jogadores: " + linha);
                        
                        linha = lerArq.readLine();
                        System.out.println("CNPJ da produtora: " + linha );
                            
                        linha = lerArq.readLine();
                        System.out.println("Nome da produtora: " + linha);

                        if (t.equals("C")) { // se for um jogo de cartas
                            linha = lerArq.readLine();
                            System.out.println("Quantidade de Cartas: " + linha);

                            linha = lerArq.readLine();
                            System.out.println("Material do baralho: " + linha + "\n");
                        }
                        else if (t.equals("E")) {
                            linha = lerArq.readLine();
                            System.out.println("Genero: " + linha);
                            
                            linha = lerArq.readLine();
                            System.out.println("Console: " + linha + "\n");
                        }
                        else if (t.equals("T")) {
                            linha = lerArq.readLine();
                            System.out.println("Material do tabuleiro: " + linha);

                            linha = lerArq.readLine();
                            System.out.println("Quantidades de pecas: " + linha + "\n");

                        }
                        linha = lerArq.readLine();
                        t = linha;
                    }
                }
                arq.close();
            }
        }
        catch (IOException e) {
          System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
    }
    
    public void removeList(int id) throws FileNotFoundException {
        if (lista.size() == 0) {
            System.out.println("Lista vazia \n");
        }
        else {
            boolean achou = false;
            for (int i = 0; i < lista.size() && !achou; i++) {
                Jogo j = lista.get(i);
                if (j.getCodigo() == id) {
                    achou = true;
                    lista.remove(j);
                    System.out.println("Removido com sucesso \n");
                    break;
                }
            }
            if (!achou) {
                System.out.println("ID invalido \n");
            }
        }
    }
    
    public void imprimeList() {
        if (this.lista.size() == 0) {
            System.out.println("Lista vazia \n");
        }
        else {
            for(Jogo jogo : this.lista) {;
                System.out.println(jogo.getTipo());
                System.out.println(jogo.getCodigo());
                System.out.println(jogo.getNome());
                System.out.println(jogo.getFaixaEtaria());
                System.out.println(jogo.getPopularidade());
                System.out.println(jogo.getAnoLancamento());
                System.out.println(jogo.getQuantidadeJogadores());
                System.out.println(jogo.getProdutora().getCnpj());
                System.out.println(jogo.getProdutora().getNome());
                if (jogo instanceof JogoCartas) {
                    System.out.println(((JogoCartas)jogo).getQuantidadeCartas());
                    System.out.println(((JogoCartas)jogo).getMaterialBaralho());
                }
                else if (jogo instanceof JogoTabuleiro) {
                    System.out.println(((JogoTabuleiro)jogo).getMaterial());
                    System.out.println(((JogoTabuleiro)jogo).getQuantidadePecas());
                }
                else if(jogo instanceof JogoEletronico) {
                    System.out.println(((JogoEletronico)jogo).getGenero());
                    System.out.println(((JogoEletronico)jogo).getConsole());
                }
            }
        }
    }
    
    public Jogo busca(int id){
        
        for(Jogo jogo : this.lista){
            
            if(jogo.getCodigo() == id){
                return jogo;
            }
        }
        return null;
    }
}

