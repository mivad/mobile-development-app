package com.imd.abastecimentosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.imd.abastecimentosapp.dao.AppDatabase;
import com.imd.abastecimentosapp.model.Veiculo;

public class AbastecimentoActivity extends AppCompatActivity {

    public static int id = 0;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent it = getIntent();
        id = it.getIntExtra("id", 0);

        Log.d("ID", Integer.toString(id));
        if(id > 0)
        {
            //btnRemover.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle("Abastecimento - Atualizar");
            id = id;
            //carregaForm(id);
        }
        else {
            //btnRemover.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Abastecimento - Cadastro");
        }

        Veiculo veiculo = new Veiculo();
        veiculo.setNome("Celta");
        veiculo.setDescricao("Chevrolet Celta 1.0 2012");
        AppDatabase.addVeiculo(veiculo);

        criarSpinner();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        Intent intent = new Intent(getBaseContext(), AbastecimentosActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }

    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the thrid item gets selected
                break;

        }
    }

    public void criarSpinner()
    {
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<Veiculo> adapter = new ArrayAdapter<Veiculo>(getBaseContext(),
                android.R.layout.simple_spinner_item, AppDatabase.veiculos);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(_this);
    }



}
