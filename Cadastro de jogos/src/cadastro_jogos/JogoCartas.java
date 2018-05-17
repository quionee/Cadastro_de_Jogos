/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;
public class JogoCartas extends Jogo {
    private int quantidadeCartas;

    public JogoCartas(int quantidadeCartas, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int qtdJogadores, Produtora produtora) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
        this.quantidadeCartas = quantidadeCartas;
    }


    public int getQuantidadeCartas() {
        return this.quantidadeCartas;
    }
    
}
