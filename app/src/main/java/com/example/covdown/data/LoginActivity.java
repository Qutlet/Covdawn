package com.example.covdown.data;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.covdown.R;
import com.example.covdown.CovdownMain;

public class LoginActivity extends AppCompatActivity {

    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText login = findViewById(R.id.login);
        final EditText pass = findViewById(R.id.pass);
        Button loginButton = findViewById(R.id.loginBtn);
        final TextView error = findViewById(R.id.errorLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean powodzenie = bazaDanych.checkUser(login.getText().toString(),pass.getText().toString());
                if (powodzenie){
                    user.setNazwa(login.getText().toString());
                    bazaDanych.getIconID();
                    Intent covdawn = new Intent(getApplicationContext(), CovdownMain.class);
                    startActivity(covdawn);
                }
                else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}