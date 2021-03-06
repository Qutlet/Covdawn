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

public class Uspokojsie_poziomy extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        bazaDanych.downloadOwnedItems();
        int poziom = 0;
        poziom = bundle.getInt("poziom");
        setContentView(R.layout.oddech_fragment_uspokojsie);
        ImageButton ikona = findViewById(R.id.activeUserIcon);
        ikona.setImageResource(user.setIconImage());
        TextView nazwa = findViewById(R.id.textView);
        nazwa.setText(user.getNazwa());
        TextView punkty = findViewById(R.id.textView2);
        punkty.setText(String.valueOf(bazaDanych.getPoints()));
        ikona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userPanel = new Intent(getApplicationContext(), UserPanel.class);
                startActivity(userPanel);
            }
        });
        TextView title2 = findViewById(R.id.textViewus);
        title2.setText(R.string.uspokojsietytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewus);
        final Button krok = findViewById(R.id.buttonus);
        final TextView opis = findViewById(R.id.textViewus2);
        final Boolean[] lastStep = {false};
        if (poziom == 1) {
            ilustracjaKroku.setImageResource(R.drawable.nos);
            opis.setText(R.string.uspokojsieopisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.uspokojsieopisk2);
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
                ilustracjaKroku.setImageResource(R.drawable.barki_gora);
                opis.setText(R.string.uspokojsie2opisk1);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.uspokojsie2opisk2);
                        ilustracjaKroku.setImageResource(R.drawable.barki_dol);
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
                ilustracjaKroku.setImageResource(R.drawable.usiadz_prosto);
                opis.setText(R.string.uspokojsie3opisk1);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.uspokojsie3opisk2);
                        ilustracjaKroku.setImageResource(R.drawable.zgarb_sie);
                        krok.setText("Zakoncz");
                        if (lastStep[0]) {
                            bazaDanych.setPoints(7);
                            finish();
                        }
                        lastStep[0] = true;
                    }
                });
        }

        if (poziom == 4) {
                ilustracjaKroku.setImageResource(R.drawable.usiadz_prosto);
                opis.setText(R.string.uspokojsie4opisk1);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.uspokojsie4opisk2);
                        krok.setText("Zakoncz");
                        if (lastStep[0]) {
                            bazaDanych.setPoints(10);
                            finish();
                        }
                        lastStep[0] = true;
                    }
                });
        }

        ImageButton cofnij = findViewById(R.id.buttonusback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}