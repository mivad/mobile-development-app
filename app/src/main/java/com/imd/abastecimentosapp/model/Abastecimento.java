package com.imd.abastecimentosapp.model;

import com.imd.abastecimentosapp.dao.AppDatabase;

public class Abastecimento {

    private int id;
    private int veiculoId;
    private double qtd;
    private double vlrUnidade;
    private double vlrTotal;
    private int quilometragem;
    private Veiculo veiculo;


    @Override
    public  String toString()
    {
        String content = Double.toString(vlrTotal) + " - " + getVeiculo();
        return content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(int veiculoId) {
        this.veiculoId = veiculoId;
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
        return vlrTotal;
    }

    public void setVlrTotal(double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public Veiculo getVeiculo() {
        return AppDatabase.getVeiculoById(veiculoId);
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }
}
