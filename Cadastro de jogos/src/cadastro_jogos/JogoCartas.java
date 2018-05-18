/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;
public class JogoCartas extends Jogo {
    private int quantidadeCartas;
    private String materialBaralho;

    public JogoCartas(int quantidadeCartas,String materialBaralho, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int qtdJogadores, Produtora produtora) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
        this.quantidadeCartas = quantidadeCartas;
        this.materialBaralho = materialBaralho;
    }

    public JogoCartas(int quantidadeCartas, String materialBaralho, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int quantidadeJogadores) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, quantidadeJogadores);
        this.quantidadeCartas = quantidadeCartas;
        this.materialBaralho = materialBaralho;
    }

    
    
    

    public int getQuantidadeCartas() {
        return this.quantidadeCartas;
    }

    public String getMaterialBaralho() {
        return materialBaralho;
    }
    
    
    @Override
    public void imprime(){
        System.out.println("Tipo: Jogo de Cartas" );
        System.out.println("Codigo: " + this.getCodigo());
        System.out.println("Nome: " + this.getNome());
        System.out.println("Faixa Etaria: " + this.getFaixaEtaria());
        System.out.println("Popularidade: " + this.getPopularidade());
        System.out.println("Ano de lancamento: " + this.getAnoLancamento());
        System.out.println("Quantidade de jogadores: " + this.getQuantidadeJogadores());
        System.out.println("Produtora: \n ome: " + this.getProdutora().getNome());
        System.out.println("CNPJ: " + this.getProdutora().getCnpj());
        System.out.println("Quantidade de cartas: " + this.getQuantidadeCartas());
        System.out.println("Material do Baralho: " + this.getMaterialBaralho());
    }
}
