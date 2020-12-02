package com.example.covdown.ui.oddech;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covdown.R;
import com.example.covdown.data.BazaDanych;

public class OddechFragment_uspokujsie extends AppCompatActivity {

    BazaDanych bazaDanych = BazaDanych.get();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oddech_fragment_uspokujsie);
        final Boolean[] lastStep = {false};
        TextView title = findViewById(R.id.textViewus);
        title.setText(R.string.uspokojsietytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewus);
        ilustracjaKroku.setImageResource(R.drawable.uspokojsiek1);
        final TextView opis = findViewById(R.id.textViewus2);
        opis.setText(R.string.uspokojsieopisk1);
        final Button krok = findViewById(R.id.buttonus);
        krok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opis.setText(R.string.uspokojsieopisk2);
                ilustracjaKroku.setImageResource(R.drawable.uspokojsiek2);
                krok.setText("zakoncz");
                lastStep[0] = true;
                if (lastStep[0])
                    bazaDanych.setPoints(1);
            }
        });
        ImageButton cofnij = findViewById(R.id.buttonusback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}