package com.example.covdown;

import android.os.Bundle;
import com.example.covdown.data.AktywnyUzytkownik;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class CovdownMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covdown_main);
        getSupportActionBar().hide();
        BottomNavigationView navView = findViewById(R.id.BNV);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.oddechFragment, R.id.muzyczkaFragment, R.id.doOdblokowaniaFragment).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}