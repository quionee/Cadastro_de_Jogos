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
public class Jogo {
    private int codigo;
    private String nome;
    private int faixaEtaria;
    private int popularidade;
    private int anoLancamento;

    public Jogo(int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento) {
        this.codigo = codigo;
        this.nome = nome;
        this.faixaEtaria = faixaEtaria;
        this.popularidade = popularidade;
        this.anoLancamento = anoLancamento;
    }

    
    public void setPopularidade(int popularidade) {
        this.popularidade = popularidade;
    }

    public String getNome() {
        return nome;
    }

    public int getFaixaEtaria() {
        return faixaEtaria;
    }
    
    public int getPopularidade() {
        return popularidade;
    }

    public int getCodigo() {
        return codigo;
    }
   
}
