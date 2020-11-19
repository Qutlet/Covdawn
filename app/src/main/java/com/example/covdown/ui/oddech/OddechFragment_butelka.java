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

public class OddechFragment_butelka extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oddech_fragment_butelka);

        TextView title = findViewById(R.id.textViewButleka1);
        title.setText(R.string.butelkatytul);
        final ImageView ilustracjaKroku = findViewById(R.id.imageViewButlka);
        ilustracjaKroku.setImageResource(R.drawable.baza);
        final TextView opis = findViewById(R.id.textViewButleka);
        opis.setText(R.string.butelkaopisk1);
        Button krok = findViewById(R.id.buttonButleka);
        krok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opis.setText(R.string.butelkaopisk2);
                //ilustracjaKroku.setImageResource(R.drawable.butlekak2);
            }
        });
        ImageButton cofnij = findViewById(R.id.buttonButBack);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
