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

public class OddechFragment_ciezar extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poziomy_ciezar);
        TextView title = findViewById(R.id.textViewCiezar9);
        title.setText(R.string.ciezartytul);
        Button lvl1 = findViewById(R.id.lvl1);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.oddech_fragment_ciezar);
                TextView title2 = findViewById(R.id.textViewCiezar2);
                title2.setText(R.string.ciezartytul);
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
                        setContentView(R.layout.poziomy_ciezar);
                    }
                });
            }
        });
        Button lvl2 = findViewById(R.id.lvl2);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.oddech_fragment_ciezar);
                TextView title2 = findViewById(R.id.textViewCiezar2);
                title2.setText(R.string.ciezartytul);
                final ImageView ilustracjaKroku = findViewById(R.id.imageViewCiezar);
                ilustracjaKroku.setImageResource(R.drawable.baza);
                final TextView opis = findViewById(R.id.textViewCiezar);
                opis.setText(R.string.ciezar2opisk1);
                Button krok = findViewById(R.id.buttonCiezar);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.ciezar2opisk2);
                        //ilustracjaKroku.setImageResource(R.drawable.ciezark2);
                    }
                });
                ImageButton cofnij = findViewById(R.id.buttonCiezarBck);
                cofnij.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.poziomy_ciezar);
                    }
                });
            }
        });
        Button lvl3 = findViewById(R.id.lvl3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.oddech_fragment_ciezar);
                TextView title2 = findViewById(R.id.textViewCiezar2);
                title2.setText(R.string.ciezartytul);
                final ImageView ilustracjaKroku = findViewById(R.id.imageViewCiezar);
                ilustracjaKroku.setImageResource(R.drawable.baza);
                final TextView opis = findViewById(R.id.textViewCiezar);
                opis.setText(R.string.ciezar3opisk1);
                Button krok = findViewById(R.id.buttonCiezar);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.ciezar3opisk2);
                        //ilustracjaKroku.setImageResource(R.drawable.ciezark2);
                    }
                });
                ImageButton cofnij = findViewById(R.id.buttonCiezarBck);
                cofnij.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.poziomy_ciezar);
                    }
                });
            }
        });
        Button lvl4 = findViewById(R.id.lvl4);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.oddech_fragment_ciezar);
                TextView title2 = findViewById(R.id.textViewCiezar2);
                title2.setText(R.string.ciezartytul);
                final ImageView ilustracjaKroku = findViewById(R.id.imageViewCiezar);
                ilustracjaKroku.setImageResource(R.drawable.baza);
                final TextView opis = findViewById(R.id.textViewCiezar);
                opis.setText(R.string.ciezar4opisk1);
                Button krok = findViewById(R.id.buttonCiezar);
                krok.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        opis.setText(R.string.ciezar4opisk2);
                        //ilustracjaKroku.setImageResource(R.drawable.ciezark2);
                    }
                });
                ImageButton cofnij = findViewById(R.id.buttonCiezarBck);
                cofnij.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.poziomy_ciezar);
                    }
                });
            }
        });
        ImageButton cofnij = findViewById(R.id.lvlback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}
