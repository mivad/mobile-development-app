package com.imd.abastecimentosapp;

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
