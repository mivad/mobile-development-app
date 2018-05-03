package com.imd.abastecimentosapp.model;


public class Veiculo {

    private int id;
    private String nome;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaocao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public  String toString()
    {
        String content =  nome; //Long.toString(id)+ " - " + nome;
        return content;
    }

}
