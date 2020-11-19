package com.example.covdown.ui.oddech;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covdown.R;

public class OddechFragment_zasznurowaneUsta extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oddech_fragment_zasznurowaneusta);

        TextView title = findViewById(R.id.textViewusta);
        title.setText(R.string.ustatytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewusta);
        ilustracjaKroku.setImageResource(R.drawable.baza);
        final TextView opis = findViewById(R.id.textViewustaopis);
        opis.setText(R.string.ustaopisk1);
        Button krok = findViewById(R.id.buttonusta);
        krok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opis.setText(R.string.ustaopisk2);
                //ilustracjaKroku.setImageResource(R.drawable.ustak2);
            }
        });
        ImageButton cofnij = findViewById(R.id.buttonustaback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}