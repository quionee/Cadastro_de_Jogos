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
public class Eletrônico extends Jogo{
    private String produtora;
    private int anoLancamento;
    private String genero;

    public Eletrônico(String produtora, int anoLancamento, String genero, int codigo, String nome, Integer faixaEtaria, int popularidade) {
        super(codigo, nome, faixaEtaria, popularidade);
        this.produtora = produtora;
        this.anoLancamento = anoLancamento;
        this.genero = genero;
    }

    public String getProdutora() {
        return produtora;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public String getGenero() {
        return genero;
    }
    
    
    
}
