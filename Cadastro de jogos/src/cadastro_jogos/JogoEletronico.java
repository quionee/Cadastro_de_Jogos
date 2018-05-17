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
public class JogoEletronico extends Jogo {
    private String produtora;
    private String genero;
    
    public JogoEletronico(String tipo, int codigo, String nome, int faixaEtaria, int popularidade, int anoLancamento, String produtora, String genero) {
        super(tipo,codigo, nome, faixaEtaria, popularidade, anoLancamento);
        this.produtora = produtora;
        this.genero = genero;
    }

    
    public String getProdutora() {
        return produtora;
    }
    
    public String getGenero() {
        return genero;
    }
    
    
    
}
