package com.imd.abastecimentosapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.imd.abastecimentosapp.dao.AppDatabase;

public class VeiculosActivity extends BaseActivity {

    @Override
    int getContentViewId() {
        getSupportActionBar().setTitle("Meus Veículos");


        return R.layout.activity_veiculos;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_veiculos;
    }




}
