package br.edu.iftm.prova.entities;

public class Candy {

    private String produto;
    private String descricao;
    private String valor;


// Getter Methods

    public String getProduto() {
        return produto;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getValor() {
        return valor;
    }

    // Setter Methods

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
