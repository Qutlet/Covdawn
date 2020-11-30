package com.example.covdown.ui.oddech;

import android.app.Activity;
import android.content.Intent;
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
        setContentView(R.layout.poziomy_rece);
        TextView title = findViewById(R.id.textViewRece1);
        title.setText(R.string.recetytul);
        Button lvl1 = findViewById(R.id.lvl1_r);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                cwicznenie1.putExtra("poziom",1);
                startActivity(cwicznenie1);
            }
        });
        Button lvl2 = findViewById(R.id.lvl2_r);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                cwicznenie1.putExtra("poziom",2);
                startActivity(cwicznenie1);
            }

        });
        Button lvl3 = findViewById(R.id.lvl3_r);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                cwicznenie1.putExtra("poziom",3);
                startActivity(cwicznenie1);
            }

        });
        Button lvl4 = findViewById(R.id.lvl4_r);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                cwicznenie1.putExtra("poziom",4);
                startActivity(cwicznenie1);
            }

        });
        ImageButton cofnij = findViewById(R.id.lvlback_r);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}