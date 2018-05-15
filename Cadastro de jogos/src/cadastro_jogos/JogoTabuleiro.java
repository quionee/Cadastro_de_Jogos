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
public class JogoTabuleiro extends Jogo {
    private String material;
    private int quantidadePecas;
    private int quantidadeJogadores;

    public JogoTabuleiro(String material, int quantidadePecas, int quantidadeJogadores, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento) {
        super(codigo, nome, faixaEtaria, popularidade, anoLancamento);
        this.material = material;
        this.quantidadePecas = quantidadePecas;
        this.quantidadeJogadores = quantidadeJogadores;
    }

    public String getMaterial() {
        return material;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }

    public int getQuantidadeJogadores() {
        return quantidadeJogadores;
    }
    
    
}
