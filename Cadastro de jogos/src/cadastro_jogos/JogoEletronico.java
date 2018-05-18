/*
   Trabalho de Paradigmas de Linguagens de Programacao
   Cadastro de Jogos
   Copyright 2018 by Lorena Tavares, Rodrigo Herculano, William Coelho
   Arquivo onde tem-se uma classe filha de Jogo, jogos eletronicos
*/

package cadastro_jogos;

public class JogoEletronico extends Jogo {
    private String genero;
    private String console;
    public JogoEletronico(String genero, String console, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int qtdJogadores, Produtora produtora) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
        this.genero = genero;
        this.console = console;
    }

    public JogoEletronico(String genero, String console, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int quantidadeJogadores) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, quantidadeJogadores);
        this.genero = genero;
        this.console = console;
    }
    
    public String getGenero() {
        return genero;
    }

    public String getConsole() {
        return console;
    }

    @Override
    public void imprime(){
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Faixa Etaria: " + this.getFaixaEtaria());
        System.out.println("Popularidade: " + this.getPopularidade());
        System.out.println("Ano de lancamento: " + this.getAnoLancamento());
        System.out.println("Quantidade de jogadores: " + this.getQuantidadeJogadores());
        System.out.println("Produtora: \n  CNPJ: " + this.getProdutora().getCnpj());
        System.out.println("  Nome: " + this.getProdutora().getNome());  
        System.out.println("Genero: " + this.getGenero());
        System.out.println("Console " + this.getConsole());
    }
}
