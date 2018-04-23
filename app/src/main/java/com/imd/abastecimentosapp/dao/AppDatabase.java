package com.imd.abastecimentosapp.dao;


import android.util.Log;

import com.imd.abastecimentosapp.model.Veiculo;

import java.util.ArrayList;
import java.util.Collections;

public class AppDatabase {
    public static ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();

    public static ArrayList<Veiculo> addVeiculo(Veiculo obj)
    {
        //Collections.reverse(veiculos);

        if(veiculos.size() == 0)
            obj.setId(1);
        else
        {
           Veiculo last = veiculos.get(veiculos.size()-1);
           int lastId = last.getId()+1;
           obj.setId(lastId);
        }

        veiculos.add(obj);
        return veiculos;
    }

}