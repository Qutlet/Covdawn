package com.example.covdown;

import android.os.Bundle;
import com.example.covdown.data.AktywnyUzytkownik;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class covdownMain extends AppCompatActivity {

    private static String user;
    private AktywnyUzytkownik aktywnyUzytkownik = AktywnyUzytkownik.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            user = null;
        } else {
            user = bundle.getString("user");
        }
        aktywnyUzytkownik.setNazwa(user);
        setContentView(R.layout.activity_covdown_main);
        BottomNavigationView navView = findViewById(R.id.BNV);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.oddechFragment, R.id.muzuczkaFragment, R.id.doOdblokowaniaFragment).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

    public static String getUser() {
        return user;
    }
}