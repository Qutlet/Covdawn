package com.example.covdown.ui.oddech;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covdown.R;

public class OddechFragment_rece extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oddech_fragment_rece);

        TextView title = findViewById(R.id.textViewRece);
        title.setText(R.string.recetytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewRece);
        ilustracjaKroku.setImageResource(R.drawable.rence_1);
        final TextView opis = findViewById(R.id.textViewrece3);
        opis.setText(R.string.receopisk1);
        Button krok = findViewById(R.id.buttonRece);
        krok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opis.setText(R.string.receopisk2);
                ilustracjaKroku.setImageResource(R.drawable.rence_2);
            }
        });
        ImageButton cofnij = findViewById(R.id.buttonReceBack);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}