/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastro_jogos;

/**
 *
 * @author aluno
 */
public class Cartas extends Jogo {
    private int quantidadeCartas;
    private int quantidadeJogadores;

    public Cartas(int quantidadeCartas, int quantidadeJogadores, int codigo, String nome, Integer faixaEtaria, int popularidade) {
        super(codigo, nome, faixaEtaria, popularidade);
        this.quantidadeCartas = quantidadeCartas;
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public int getQuantidadeCartas() {
        return quantidadeCartas;
    }

    public int getQuantidadeJogadores() {
        return quantidadeJogadores;
    }
    
}
