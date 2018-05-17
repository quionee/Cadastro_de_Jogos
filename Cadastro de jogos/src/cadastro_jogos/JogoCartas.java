/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;
public class JogoCartas extends Jogo {
    private int quantidadeCartas;
    private int quantidadeJogadores;

    public JogoCartas(String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int quantidadeCartas, int quantidadeJogadores) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento);
        this.quantidadeCartas = quantidadeCartas;
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public int getQuantidadeCartas() {
        return this.quantidadeCartas;
    }

    public int getQuantidadeJogadores() {
        return this.quantidadeJogadores;
    }
    
}
