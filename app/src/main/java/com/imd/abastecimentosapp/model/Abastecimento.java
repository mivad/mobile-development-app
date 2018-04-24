package com.imd.abastecimentosapp.model;

import com.imd.abastecimentosapp.dao.AppDatabase;

public class Abastecimento {

    private int id;
    private String veiculo;
    private double qtd;
    private double vlrUnidade;
    private double vlrTotal;
    private int quilometragem;


    @Override
    public  String toString()
    {

        String content = "R$ " + String.format( "%.2f", getVlrTotal() )+ " - " + getVeiculo();
        return content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }

    public double getVlrUnidade() {
        return vlrUnidade;
    }

    public void setVlrUnidade(double vlrUnidade) {
        this.vlrUnidade = vlrUnidade;
    }

    public double getVlrTotal() {
        return vlrUnidade*qtd;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
}
