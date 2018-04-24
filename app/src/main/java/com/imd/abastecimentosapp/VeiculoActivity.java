package com.imd.abastecimentosapp;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imd.abastecimentosapp.dao.AppDatabase;
import com.imd.abastecimentosapp.model.Veiculo;

public class VeiculoActivity extends AppCompatActivity {


    public static int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



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

        final Button btnRemover = findViewById(R.id.btnRemover);
        btnRemover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(remover())
                {
                    Toast toast = Toast.makeText(getBaseContext(), "Registro excluído com sucesso.", Toast.LENGTH_LONG);
                    toast.show();
                    onBackPressed();
                }
            }
        });


        Intent it = getIntent();
        id = it.getIntExtra("id", 0);

        Log.d("ID", Integer.toString(id));
        if(id > 0)
        {
            btnRemover.setVisibility(View.VISIBLE);
            getSupportActionBar().setTitle("Veículo - Atualizar");
            id = id;
            carregaForm(id);
        }
        else {
            btnRemover.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Veículo - Cadastro");
        }
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

        Intent intent = new Intent(getBaseContext(), VeiculosActivity.class);
        startActivity(intent);

        overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit);
    }


    public boolean salvar()
    {

        Veiculo veiculo = new Veiculo();

        EditText txtNome = findViewById(R.id.txtNome);
        veiculo.setNome(txtNome.getText().toString());

        if(txtNome.length() == 0)
        {
            Toast toast = Toast.makeText(getBaseContext(), "Nome é um campo obrigatório.", Toast.LENGTH_LONG);
            toast.show();
            return false;
        }

        EditText txtDescricao = findViewById(R.id.txtDescricao);
        veiculo.setDescricao(txtDescricao.getText().toString());

        if(id == 0) {
            AppDatabase.addVeiculo(veiculo);
        }
        else
        {
            veiculo.setId(id);
            AppDatabase.atualizarVeiculo(veiculo);

        }

        for (Veiculo item : AppDatabase.veiculos) {
            Log.d("item", Integer.toString(item.getId()));
        }

        return true;
    }


    public boolean remover()
    {
        AppDatabase.removerVeiculo(id);
        return true;
    }



    public void carregaForm(int id)
    {
        Veiculo encontrado = AppDatabase.getVeiculoById(id);
        if(encontrado != null) {
            EditText txtDescricao = findViewById(R.id.txtDescricao);
            txtDescricao.setText(encontrado.getDescricaocao());

            EditText txtNome = findViewById(R.id.txtNome);
            txtNome.setText(encontrado.getNome());
        }
    }
}
