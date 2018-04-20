package com.imd.abastecimentosapp;

public class AbastecimentosActivity extends BaseActivity {


    @Override
    int getContentViewId() {
        getSupportActionBar().setTitle("Abastecimentos");
        return R.layout.activity_abastecimentos;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_abastecimentos;
    }

}
