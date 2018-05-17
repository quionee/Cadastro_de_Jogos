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

    public JogoTabuleiro(String material, int quantidadePecas, String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, int qtdJogadores, Produtora produtora) {
        super(tipo, codigo, nome, faixaEtaria, popularidade, anoLancamento, qtdJogadores, produtora);
        this.material = material;
        this.quantidadePecas = quantidadePecas;
    }



    public String getMaterial() {
        return material;
    }

    public int getQuantidadePecas() {
        return quantidadePecas;
    }
}
