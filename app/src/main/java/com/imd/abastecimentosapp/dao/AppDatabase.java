package com.imd.abastecimentosapp.dao;


import com.imd.abastecimentosapp.model.Veiculo;

import java.util.ArrayList;

public class AppDatabase {
    public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();


    public static ArrayList<Veiculo> addVeiculo(Veiculo obj)
    {
        veiculos.add(obj);

        return veiculos;
    }

}