/*
   Trabalho de Paradigmas de Linguagens de Programacao
   Cadastro de Jogos
   Copyright 2018 by Lorena Tavares, Rodrigo Herculano, William Coelho
   Arquivo onde tem-se uma classe filha de Jogo, jodos de tabuleiro
*/

package cadastro_jogos;

public class JogoTabuleiro extends Jogo {
    private String material;
    private int quantidadePecas;

    public JogoTabuleiro(String material, int quantidadePecas, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int qtdJogadores, Produtora produtora) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
        this.material = material;
        this.quantidadePecas = quantidadePecas;
    }

    public JogoTabuleiro(String material, int quantidadePecas, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int quantidadeJogadores) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, quantidadeJogadores);
        this.material = material;
        this.quantidadePecas = quantidadePecas;
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }
    
    @Override
    public void imprime() {
        System.out.println("Tipo: " + this.getTipo());
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Faixa Etaria: " + this.getFaixaEtaria());
        System.out.println("Popularidade: " + this.getPopularidade());
        System.out.println("Ano de lancamento: " + this.getAnoLancamento());
        System.out.println("Quantidade de jogadores: " + this.getQuantidadeJogadores());
        System.out.println("Produtora: \n  CNPJ: " + this.getProdutora().getCnpj());
        System.out.println("  Nome: " + this.getProdutora().getNome());
        System.out.println("Material do Tabuleiro: " + this.getMaterial());
        System.out.println("Quantidade de pecas: " + this.getQuantidadePecas());
    }
}
