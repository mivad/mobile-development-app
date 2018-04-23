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

    public static Veiculo atualizarVeiculo(Veiculo veiculo)
    {

        int index = 0;
        Veiculo encontrado = new Veiculo();

        for(int i = 0; i< veiculos.size(); i++)
        {
            encontrado = veiculos.get(i);
            if(encontrado.getId() == veiculo.getId())
                index = i;
        }

        encontrado.setNome(veiculo.getNome());
        encontrado.setDescricao(veiculo.getDescricaocao());
        encontrado.setId(veiculo.getId());

        veiculos.remove(index);

        //veiculos.add(encontrado);

        return veiculo;
    }

    public static Veiculo getVeiculoById(int id)
    {
        Veiculo encontrado = new Veiculo();

        for (Veiculo obj: veiculos) {

            if(obj.getId() == id)
                encontrado = obj;
        }

        return encontrado;
    }

}