package com.example.covdown.ui.oddech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.covdown.R;
import com.example.covdown.data.BazaDanych;

public class Ciezar_poziomy extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        int poziom = 0;
        poziom = bundle.getInt("poziom");
        setContentView(R.layout.oddech_fragment_ciezar);
        TextView title2 = findViewById(R.id.textViewCiezar2);
        title2.setText(R.string.ciezartytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewCiezar);
        final Button krok = findViewById(R.id.buttonCiezar);
        final TextView opis = findViewById(R.id.textViewCiezar);
        final Boolean[] lastStep = {false};
        if (poziom == 1) {
            ilustracjaKroku.setImageResource(R.drawable.baza);
            opis.setText(R.string.ciezaropisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.ciezaropisk2);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(1, com.example.covdown.covdownMain.getUser());
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        if (poziom == 2) {
            ilustracjaKroku.setImageResource(R.drawable.baza);
            opis.setText(R.string.ciezar2opisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.ciezar2opisk2);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(1, com.example.covdown.covdownMain.getUser());
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        if (poziom == 3) {
            ilustracjaKroku.setImageResource(R.drawable.baza);
            opis.setText(R.string.ciezar3opisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.ciezar3opisk2);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(1, com.example.covdown.covdownMain.getUser());
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        if (poziom == 4) {
            ilustracjaKroku.setImageResource(R.drawable.baza);
            opis.setText(R.string.ciezar4opisk1);
            krok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opis.setText(R.string.ciezar4opisk2);
                    krok.setText("Zakoncz");
                    if (lastStep[0]) {
                        bazaDanych.setPoints(1, com.example.covdown.covdownMain.getUser());
                        finish();
                    }
                    lastStep[0] = true;
                }
            });
        }

        ImageButton cofnij = findViewById(R.id.buttonCiezarBck);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    }

