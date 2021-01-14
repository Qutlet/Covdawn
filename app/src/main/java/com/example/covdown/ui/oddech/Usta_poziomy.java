package com.example.covdown.ui.oddech;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;
import com.example.covdown.ui.userPanel.UserPanel;

public class Usta_poziomy extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        bazaDanych.downloadOwnedItems();
        int poziom = 0;
        poziom = bundle.getInt("poziom");
        setContentView(R.layout.oddech_fragment_zasznurowaneusta);
        ImageButton ikona = findViewById(R.id.activeUserIcon);
        TextView nazwa = findViewById(R.id.textView);
        nazwa.setText(user.getNazwa());
        ikona.setImageResource(user.setIconImage());
        TextView punkty = findViewById(R.id.textView2);
        punkty.setText(String.valueOf(bazaDanych.getPoints()));
        ikona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userPanel = new Intent(getApplicationContext(), UserPanel.class);
                startActivity(userPanel);
            }
        });
        TextView title2 = findViewById(R.id.textViewusta);
        title2.setText(R.string.ustatytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewusta);
        final Button krok = findViewById(R.id.buttonusta);
        final TextView opis = findViewById(R.id.textViewustaopis);
        final Boolean[] lastStep = {false};
        if (poziom == 1) {
            ilustracjaKroku.setImageResource(R.drawable.nos);
            opis.setText(R.string.ustaopisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.ustaopisk2);
                    ilustracjaKroku.setImageResource(R.drawable.dziubek);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(5);
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        if (poziom == 2) {
            ilustracjaKroku.setImageResource(R.drawable.nos);
            opis.setText(R.string.usta2opisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.usta2opisk2);
                    ilustracjaKroku.setImageResource(R.drawable.dziubek);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(5);
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        if (poziom == 3) {
                ilustracjaKroku.setImageResource(R.drawable.nos);
                opis.setText(R.string.butelka3opisk1);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.butelka3opisk2);
                        ilustracjaKroku.setImageResource(R.drawable.zaszyte);
                        krok.setText("Zakoncz");
                        if (lastStep[0]) {
                            bazaDanych.setPoints(7);
                            finish();
                        }
                        lastStep[0] = true;
                    }
             });
        }

        ImageButton cofnij = findViewById(R.id.buttonustaback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}