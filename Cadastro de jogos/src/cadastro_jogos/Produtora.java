/*
   Trabalho de Paradigmas de Linguagens de Programacao
   Cadastro de Jogos
   Copyright 2018 by Lorena Tavares, Rodrigo Herculano, William Coelho
   Arquivo onde tem-se uma classe que e' atributo da classe Jogo
*/

package cadastro_jogos;

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
