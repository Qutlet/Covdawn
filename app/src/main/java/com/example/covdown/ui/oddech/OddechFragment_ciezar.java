package com.example.covdown.ui.oddech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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
                Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                cwicznenie.putExtra("poziom",1);
                startActivity(cwicznenie);
            }

        });
        Button lvl2 = findViewById(R.id.lvl2);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                cwicznenie.putExtra("poziom",2);
                startActivity(cwicznenie);
            }

        }); Button lvl3 = findViewById(R.id.lvl3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                cwicznenie.putExtra("poziom",3);
                startActivity(cwicznenie);
            }

        }); Button lvl4 = findViewById(R.id.lvl4);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                cwicznenie.putExtra("poziom",4);
                startActivity(cwicznenie);
            }

        });
        ImageButton cofnij = findViewById(R.id.lvlback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}
