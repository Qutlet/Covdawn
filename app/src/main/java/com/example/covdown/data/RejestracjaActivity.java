package com.example.covdown.data;

import androidx.appcompat.app.AppCompatActivity;
import com.example.covdown.R;
import com.example.covdown.CovdownMain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RejestracjaActivity extends AppCompatActivity {

    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rejestracja);
        final EditText signName = findViewById(R.id.signName);
        final EditText signPass = findViewById(R.id.signPass);
        final EditText signDate = findViewById(R.id.signDate);
        final TextView errorData = findViewById(R.id.errorData);
        Button sign = findViewById(R.id.sign);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean powodzenia = checkDate("yyyy-MM-dd",signDate.getText().toString());
                if (powodzenia){
                    boolean powodzenie =  bazaDanych.addUser(signName.getText().toString(),signPass.getText().toString(),signDate.getText().toString());
                    if (powodzenie){
                        user.setNazwa(signName.getText().toString());
                        Intent covdawn = new Intent(getApplicationContext(), CovdownMain.class);
                        startActivity(covdawn);
                    }
                } else {
                    errorData.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    private boolean checkDate(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}