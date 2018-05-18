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
public class Produtora {
    private String cnpj;
    private String nome;

    public Produtora(String cnpj, String nome) {
        this.cnpj = cnpj;
        this.nome = nome;
    }

    public Produtora() {
        this.cnpj = "-";
        this.nome = "-";
    }
    
    

    public String getCnpj() {
        return cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
