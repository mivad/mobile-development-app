package com.imd.abastecimentosapp;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.imd.abastecimentosapp.dao.AppDatabase;
import com.imd.abastecimentosapp.model.Veiculo;

public class VeiculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Veículo - Cadastro");


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
        super.onBackPressed();
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


        AppDatabase.addVeiculo(veiculo);

        for ( Veiculo obj :AppDatabase.veiculos) {
            Log.d("veiculos",obj.getNome() );
        }

        return true;

    }
}
