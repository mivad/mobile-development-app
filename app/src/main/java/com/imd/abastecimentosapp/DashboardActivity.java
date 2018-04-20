package com.imd.abastecimentosapp;

public class DashboardActivity extends BaseActivity {


    @Override
    int getContentViewId() {
        getSupportActionBar().setTitle("Dashboard");
        return R.layout.activity_dashboard;
    }

    @Override
    int getNavigationMenuItemId() {
        return R.id.navigation_dashboard;
    }

}

