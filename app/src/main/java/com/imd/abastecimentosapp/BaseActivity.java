package com.imd.abastecimentosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.imd.abastecimentosapp.dao.AppDatabase;
import com.imd.abastecimentosapp.model.Abastecimento;
import com.imd.abastecimentosapp.model.Veiculo;


public abstract class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    protected BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(this);


        loadVeiculosActivityComponents();
        loadAbastecimentosActivityComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
        carregaListaVeiculos();
        updateNavigationBarState();


        final TextView txtNenhum = findViewById(R.id.txtNenhum);
        if(txtNenhum != null) {
            if (AppDatabase.veiculos.size() == 0)
                txtNenhum.setVisibility(View.VISIBLE);
            else
                txtNenhum.setVisibility(View.GONE);
        }
    }

    // Remove inter-activity transition to avoid screen tossing on tapping bottom navigation items
    @Override
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.postDelayed(() -> {
            int itemId = item.getItemId();
            if (itemId == R.id.navigation_abastecimentos) {
                startActivity(new Intent(this, AbastecimentosActivity.class));
            } else if (itemId == R.id.navigation_dashboard) {
                startActivity(new Intent(this, DashboardActivity.class));
            } else if (itemId == R.id.navigation_veiculos) {
                startActivity(new Intent(this, VeiculosActivity.class));
            }
            finish();
        }, 300);
        return true;
    }

    private void updateNavigationBarState(){
        int actionId = getNavigationMenuItemId();
        selectBottomNavigationBarItem(actionId);
    }

    void selectBottomNavigationBarItem(int itemId) {
        MenuItem item = navigationView.getMenu().findItem(itemId);
        item.setChecked(true);
    }

    abstract int getContentViewId();

    abstract int getNavigationMenuItemId();


    public void loadVeiculosActivityComponents()
    {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        if(fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), VeiculoActivity.class);
                    startActivity(intent);
                    overridePendingTransition( R.anim.slide_in, R.anim.slide_out);
                }
            });
        }
    }

    public void loadAbastecimentosActivityComponents()
    {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAddAbastecimento);
        if(fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), AbastecimentoActivity.class);
                    startActivity(intent);
                    overridePendingTransition( R.anim.slide_in, R.anim.slide_out);
                }
            });
        }
    }


    public void carregaListaVeiculos()
    {
        ListView listView = (ListView) findViewById(R.id.veiculosListView);
        if(listView != null)
        {
            ArrayAdapter<Veiculo> adaptador = new ArrayAdapter<Veiculo>(getBaseContext(), android.R.layout.simple_list_item_1, AppDatabase.veiculos);
            listView.setAdapter(adaptador);


            registerForContextMenu(listView);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapter, View view,
                                        int position, long id) {

                    Veiculo veiculoSelecionado = AppDatabase.veiculos.get(position);

                    Intent intent = new Intent(getBaseContext(), VeiculoActivity.class);

                    intent.putExtra("id", veiculoSelecionado.getId());

                    startActivity(intent);

                }

            });

        }


    }


}

