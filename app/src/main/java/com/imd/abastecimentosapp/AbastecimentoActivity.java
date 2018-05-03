package com.imd.abastecimentosapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.imd.abastecimentosapp.dao.AppDatabase;
import com.imd.abastecimentosapp.model.Abastecimento;
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

        criarSpinner();


        final Button button = findViewById(R.id.btnSalvar);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(salvar())
                {
                    Toast toast = Toast.makeText(getBaseContext(), "Registro salvo com sucesso.", Toast.LENGTH_LONG);
                    toast.show();
                    onBackPressed();
                }
            }
        });
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


    public boolean salvar()
    {

        Abastecimento abast = new Abastecimento();

        EditText txtVlrUnidade = findViewById(R.id.txtVlrUnidade);

        if(txtVlrUnidade.length() == 0)
        {
            Toast toast = Toast.makeText(getBaseContext(), "Preço do Litro é um campo obrigatório.", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }
        abast.setVlrUnidade(Double.parseDouble(txtVlrUnidade.getText().toString()));

        EditText txtQtdAbastecida = findViewById(R.id.txtQtdAbastecida);
        if(txtQtdAbastecida != null)
        {
            abast.setQtd(Double.parseDouble(txtQtdAbastecida.getText().toString()));
        }


        Spinner mySpinner=(Spinner) findViewById(R.id.spinner);
        if(mySpinner != null) {
            String text = mySpinner.getSelectedItem().toString();

            abast.setVeiculo(text);
        }


        if(id == 0) {
            AppDatabase.addAbastecimento(abast);
        }
        else
        {
            //veiculo.setId(id);
            //AppDatabase.atualizarVeiculo(veiculo);

        }

        for (Abastecimento item : AppDatabase.abastecimentos) {
            Log.d("getId", Integer.toString(item.getId()));
            Log.d("getQtd", Double.toString(item.getQtd()));
            Log.d("getVlrUnidade", Double.toString(item.getVlrUnidade()));
        }

        return true;
    }





}
