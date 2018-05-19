/*
   Trabalho de Paradigmas de Linguagens de Programacao
   Cadastro de Jogos
   Copyright 2018 by Lorena Tavares, Rodrigo Herculano, William Coelho
   Arquivo responsavel pela gestao de cadastro dos dados a serem tratados
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

    private ArrayList<Jogo> lista;

    public Controlador() {
        this.lista = new ArrayList<Jogo>(); // constroi ArrayList onde ficarao armazenados os dados na memoria
    }

    private Scanner ler = new Scanner(System.in); // cria objeto de leitura

    void cadastraJogo() {
        System.out.print("Digite o tipo do jogo:\n -T (tabuleiro)\n -C (cartas)\n -E (eletronico)\n\nTipo: " );
        String tipo = ler.nextLine(); // le o tipo do jogo
        if (tipo.equals("C") || tipo.equals("T") || tipo.equals("E") ) { // verifica se o tipo do jogo a ser inserido e' valido
            int codigo;
            boolean jaExiste = false;
            do { // tratamento para codigos de jogos ja existentes
                jaExiste = false;
                System.out.print("Codigo: ");
                codigo = Integer.parseInt(ler.nextLine());
                for (Jogo jogo : this.lista) { // Para cada jogo existente na lista, verifica se algum dos jogos ja possui o codigo inserido
                    if (jogo.getCodigo() == codigo) {
                        System.out.println("ID ja existente, tente outro: "); // Caso o codigo ja exista e' pedido um codigo diferente
                        jaExiste = true;
                    }
                }
            } while (jaExiste);
            
            // Ao inserir um codigo que ainda nao existe, todos os outros atributos sao lidos em seguida
            // Os atributos comuns a todas as classes filhas (atributos herdados da classe pai (Jogo)) sao lidos
            System.out.print("Nome: ");
            String nome = ler.nextLine();
            
            System.out.print("Faixa etaria (0 a 18): ");
            int faixaEtaria = Integer.parseInt(ler.nextLine());
            
            System.out.print("Popularidade (1 a 5): ");
            int popularidade = Integer.parseInt(ler.nextLine());
            
            System.out.print("Ano de Lancamento: ");
            int anoLancamento = Integer.parseInt(ler.nextLine());
   
            System.out.print("Quantidade de Jogadores: ");
            int qtdJogadores = Integer.parseInt(ler.nextLine());
            
            System.out.print("O jogo possui uma produtora conhecida?\n -1: Sim\n -2: Nao\n Resposta: ");
            int opcao = Integer.parseInt(ler.nextLine()); // Escolhe se o jogo possui ou nao uma produtora
            if (opcao == 1) { // Quando ha uma produtora, os atributos da mesma sao lidos
                System.out.print("Produtora: \n");
                
                System.out.print("CNPJ: ");
                String cnpj = ler.nextLine();

                System.out.print("Nome: ");
                String nomeP = ler.nextLine();

                Produtora produtora = new Produtora(cnpj,nomeP); // A produtora e'criada com os atributos lidos e utilizada como parametro no construtor das classes
                // Para cada tipo de classe filha sao lidos os atributos exclusivos de cada uma
                if (tipo.equals("C")) { // Insere um jogo de cartas 
                    System.out.print("Quantidade de Cartas: ");
                    int qtdCartas = Integer.parseInt(ler.nextLine());

                    System.out.print("Material do baralho: ");
                    String materialBaralho = ler.nextLine();
                    
                    Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("E")) { // Insere um jogo eletronico
                    System.out.print("Genero: ");
                    String genero = ler.nextLine();
                    
                    System.out.print("Console: ");
                    String console = ler.nextLine();
                    
                    Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("T")) { // Insere um jogo de tabuleiro
                    System.out.print("Material do tabuleiro: ");
                    String material = ler.nextLine();

                    System.out.print("Quantidade de Pecas: ");
                    int qtdPecas = Integer.parseInt(ler.nextLine());

                    Jogo umJogo = new JogoTabuleiro(material,qtdPecas, tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
                    this.lista.add(umJogo);
                }
            }
            else if (opcao == 2) { // Quando nao ha uma produtora os atributos da mesma nao sao lidos
                // Para cada tipo de classe filha sao lidos os atributos exclusivos de cada uma
                if (tipo.equals("C")) { // Insere um jogo de cartas 
                    System.out.print("Quantidade de Cartas: ");
                    int qtdCartas = Integer.parseInt(ler.nextLine());

                    System.out.print("Material do baralho: ");
                    String materialBaralho = ler.nextLine();
                    Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("E")) { // Insere um jogo eletronico
                    System.out.print("Genero: ");
                    String genero = ler.nextLine();
                    
                    System.out.print("Console: ");
                    String console = ler.nextLine();
                    
                    Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores);
                    this.lista.add(umJogo);
                }
                else if (tipo.equals("T")) { // Insere um jogo de tabuleiro
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
            System.out.println("\nOpcao invalida, tente novamente!\n");
        }
    }
    
    public void salvarNoArq() throws IOException { // Salva os dados do ArrayList (memoria) no arquivo
        FileWriter arquivo = new FileWriter("cadastro_de_jogos", false); // Cria objeto que recebe o arquivo em modo de escrita (sempre sobrescreve o conteudo)
        PrintWriter gravarArq = new PrintWriter(arquivo); // Cria objeto de escrita para o arquivo
        for (Jogo jogo : this.lista) { // Para cada jogo na lista os atributos comuns a todas as classes filhas (atributos herdados da classe pai (Jogo)) sao lidos
            gravarArq.println(jogo.getTipo());
            gravarArq.println(jogo.getCodigo());
            gravarArq.println(jogo.getNome());
            gravarArq.println(jogo.getFaixaEtaria());
            gravarArq.println(jogo.getPopularidade());
            gravarArq.println(jogo.getAnoLancamento());
            gravarArq.println(jogo.getQuantidadeJogadores());
            gravarArq.println(jogo.produtora.getCnpj());
            gravarArq.println(jogo.produtora.getNome());
            
            // Para cada tipo de classe filha sao gravados os atributos exclusivos de cada uma
            if (jogo instanceof JogoCartas) {  // Salva um jogo de cartas
                gravarArq.println(((JogoCartas)jogo).getQuantidadeCartas());
                gravarArq.println(((JogoCartas)jogo).getMaterialBaralho());
                System.out.println(((JogoCartas)jogo).getMaterialBaralho());
            }
            else if (jogo instanceof JogoTabuleiro) { // Salva um jogo de tabuleiro
                gravarArq.println(((JogoTabuleiro)jogo).getMaterial());
                gravarArq.println(((JogoTabuleiro)jogo).getQuantidadePecas());;
            }
            else if (jogo instanceof JogoEletronico) { // Salva um jogo eletronico
                gravarArq.println(((JogoEletronico)jogo).getGenero());
                gravarArq.println(((JogoEletronico)jogo).getConsole());
            }
        }
            gravarArq.flush();
    }
    
    public void carregarArquivo() throws IOException {
        try {
            FileReader arq = new FileReader("cadastro_de_jogos"); // Cria objeto que recebe o arquivo em modo de leitura
            BufferedReader lerArq = new BufferedReader(arq); // Cria objeto de leitura do arquivo
            String linha = lerArq.readLine(); // Le a primeira linha
            // A variavel "linha" recebe o valor "null" quando o processo
            // de repeticao atingir o final do arquivo texto
            if (linha == null) { // Verifica se o arquivo esta vazio
                System.out.println("Arquivo vazio \n");
            }
            else {
                this.lista.clear(); // Limpa a lista de jogos para escrever os dados do arquivo na lista
                String tipo = linha;
                while (linha != null) { // Enquanto nao chegar no fim do arquivo
                    if (tipo.equals("C") || tipo.equals("T") || tipo.equals("E")) { // Verifica se o tipo do jogo a ser carregado em memoria
                        // Os atributos comuns a todas as classes filhas (atributos herdados da classe pai (Jogo)) sao lidos
                        int codigo = Integer.parseInt(lerArq.readLine());
                        String nome = lerArq.readLine();
                        int faixaEtaria = Integer.parseInt(lerArq.readLine());
                        int popularidade = Integer.parseInt(lerArq.readLine());
                        int anoLancamento = Integer.parseInt(lerArq.readLine());
                        int qtdJogadores = Integer.parseInt(lerArq.readLine());
                        String cnpj = lerArq.readLine();
                        String nomeP = lerArq.readLine();
                       
                        Produtora produtora = new Produtora(cnpj,nomeP);
                        // Para cada tipo de classe filha sao lidos os atributos exclusivos de cada uma
                        if (tipo.equals("C")) { // Carrega os atributos de um jogo de cartas
                            int qtdCartas = Integer.parseInt(lerArq.readLine());
                            String materialBaralho = lerArq.readLine();
                            Jogo umJogo = new JogoCartas(qtdCartas, materialBaralho, tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoCartas)umJogo);
                        }
                        else if (tipo.equals("E")) { // Carrega os atributos de um jogo eletronico
                            String genero = lerArq.readLine();
                            String console = lerArq.readLine();
                            Jogo umJogo = new JogoEletronico(genero, console,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoEletronico)umJogo);
                        }
                        else if (tipo.equals("T")) {// Carrega os atributos de um jogo de tabuleiro
                            String material = lerArq.readLine();
                            int qtdPecas = Integer.parseInt(lerArq.readLine());
                            Jogo umJogo = new JogoTabuleiro(material,qtdPecas,tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento,qtdJogadores,produtora);
                            this.lista.add((JogoTabuleiro)umJogo);
                        }
                        linha = lerArq.readLine(); // Le a proxima linha (tipo do  proximo jogo)
                        tipo = linha; // Tipo recebe a linha
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
            FileReader arq = new FileReader("cadastro_de_jogos"); // Cria objeto que recebe o arquivo em modo de leitura
            BufferedReader lerArq = new BufferedReader(arq); // Cria objeto de leitura do arquivo

            String linha = lerArq.readLine(); // Le a primeira linha
            // A variavel "linha" recebe o valor "null" quando o processo
            // de repeticao atingir o final do arquivo texto
            if (linha == null) {
                System.out.println("Arquivo vazio \n");
            }
            else {
                String t = linha;
                while (linha != null) {
                    System.out.println("Tipo: " + t);
                    if (t.equals("C") || t.equals("T") || t.equals("E") ) { // Verifica se o tipo do jogo e' valido
                        // Os atributos comuns a todas as classes filhas (atributos herdados da classe pai (Jogo)) sao lidos
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
                        
                        System.out.println("Produtora:");
                        linha = lerArq.readLine();
                        System.out.println("  CNPJ: " + linha );
                            
                        linha = lerArq.readLine();
                        System.out.println("  Nome: " + linha);
                        // Para cada tipo de classe filha sao lidos os atributos exclusivos de cada uma
                        if (t.equals("C")) { // Le um jogo de cartas
                            linha = lerArq.readLine();
                            System.out.println("Quantidade de Cartas: " + linha);

                            linha = lerArq.readLine();
                            System.out.println("Material do baralho: " + linha + "\n");
                        }
                        else if (t.equals("E")) { // Le um jogo eletronico
                            linha = lerArq.readLine();
                            System.out.println("Genero: " + linha);
                            
                            linha = lerArq.readLine();
                            System.out.println("Console: " + linha + "\n");
                        }
                        else if (t.equals("T")) { // Le um jogo tabuleiro
                            linha = lerArq.readLine();
                            System.out.println("Material do tabuleiro: " + linha);

                            linha = lerArq.readLine();
                            System.out.println("Quantidades de pecas: " + linha + "\n");
                        }
                        linha = lerArq.readLine(); // Le a proxima linha (tipo do  proximo jogo)
                        t = linha; // Tipo recebe a linha
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
    
    public void removeList(int codigo) throws FileNotFoundException {
        if (lista.size() == 0) { // Se nao ha nenhum jogo na lista
            System.out.println("\nLista vazia \n");
        }
        else {
            boolean achou = false;
            for (int i = 0; i < lista.size() && !achou; i++) { 
                Jogo j = lista.get(i);
                if (j.getCodigo() == codigo) { // Compara o codigo inserido com o codigo de cada jogo na lista
                    achou = true;
                    lista.remove(j);
                    System.out.println("\nRemovido com sucesso \n"); // Se ha um jogo com o codigo inserido ele e' removido da lista
                    break;
                }
            }
            if (!achou) {
                System.out.println("\nID invalido \n"); // Se nenhum jogo tem o codigo correspondente ao codigo inserido, e' dada a mensagem de erro
            }
        }
    }
    
    public void imprimeList() {
        if (this.lista.size() == 0) { // Se a lista estiver vazia e' dada mensagem de erro 
            System.out.println("Lista vazia \n");
        }
        else {
            for (Jogo jogo : this.lista) { // Para cada jogo da lista
                // Os atributos comuns a todas as classes filhas (atributos herdados da classe pai (Jogo)) sao impresso
                System.out.println("\nTipo: " + jogo.getTipo());
                System.out.println("Codigo: " + jogo.getCodigo());
                System.out.println("Nome: " + jogo.getNome());
                System.out.println("Faixa etaria: " + jogo.getFaixaEtaria());
                System.out.println("Popularidade: " + jogo.getPopularidade());
                System.out.println("Ano de Lancamento: " + jogo.getAnoLancamento());
                System.out.println("Quantidade de jogadores: " + jogo.getQuantidadeJogadores());
                System.out.println("Produtora:\n  CNPJ: " + jogo.getProdutora().getCnpj());
                System.out.println("  Nome: " + jogo.getProdutora().getNome());
                // Para cada tipo de classe filha sao impressos os atributos exclusivos de cada uma
                // Cada condicao verifica se jogo e' uma instancia das classes filhas
                if (jogo instanceof JogoCartas) {//imprime os atributos de um jogo de cartas
                    System.out.println("Quantidade de cartas: " + ((JogoCartas)jogo).getQuantidadeCartas());
                    System.out.println("Material do baralho: " + ((JogoCartas)jogo).getMaterialBaralho());
                }
                else if (jogo instanceof JogoTabuleiro) { // Imprime os atributos de um jogo de tabuleiro
                    System.out.println("Material: " + ((JogoTabuleiro)jogo).getMaterial());
                    System.out.println("Quantidade de Pecas: " + ((JogoTabuleiro)jogo).getQuantidadePecas());
                }
                else if (jogo instanceof JogoEletronico) { // Imprime os atributos de um jogo eletronico
                    System.out.println("Genero: " + ((JogoEletronico)jogo).getGenero());
                    System.out.println("Console: " + ((JogoEletronico)jogo).getConsole());
                }
            }
        }
    }
    
    public Jogo busca(int codigo){
        for (Jogo jogo : this.lista){ // Para cada jogo na lista verifica se o codigo inserido e' igual ao codigo do jogo
            if (jogo.getCodigo() == codigo){ // Se o codigo buscado foi encontrado o jogo e' retornado
                return jogo;
            }
        }
        return null; // Se o codigo inserido nao foi encontrado e retornado "null" 
    }
}

