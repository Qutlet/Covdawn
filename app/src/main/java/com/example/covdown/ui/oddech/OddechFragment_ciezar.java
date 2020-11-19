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

public class OddechFragment_ciezar extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oddech_fragment_ciezar);

        TextView title = findViewById(R.id.textViewCiezar2);
        title.setText(R.string.ciezartytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewCiezar);
        ilustracjaKroku.setImageResource(R.drawable.baza);
        final TextView opis = findViewById(R.id.textViewCiezar);
        opis.setText(R.string.ciezaropisk1);
        Button krok = findViewById(R.id.buttonCiezar);
        krok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opis.setText(R.string.ciezaropisk2);
                //ilustracjaKroku.setImageResource(R.drawable.ciezark2);
            }
        });
        ImageButton cofnij = findViewById(R.id.buttonCiezarBck);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
