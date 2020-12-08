package com.example.covdown.ui.oddech;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;

public class OddechFragment_rece extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poziomy_rece);
        bazaDanych.downloadOwnedItems();
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
                if (user.getOdblokowane().find("C3P2")) {
                    Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                    cwicznenie1.putExtra("poziom", 2);
                    startActivity(cwicznenie1);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_rece.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 2?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //user.addItem(C3P2);
                                        //BazaDanych.setPoints(-10);
                                        Toast.makeText(getApplicationContext(),"Odblokowano poziom 2",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Nie masz wystraczająco dużo punktów",Toast.LENGTH_SHORT).show();
                                    }
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Anuluj",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.show();
                }
            }

        });
        Button lvl3 = findViewById(R.id.lvl3_r);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("C3P3")) {
                    Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                    cwicznenie1.putExtra("poziom", 3);
                    startActivity(cwicznenie1);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_rece.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 3?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //user.addItem(C3P3);
                                        //BazaDanych.setPoints(-10);
                                        Toast.makeText(getApplicationContext(),"Odblokowano poziom 3",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Nie masz wystraczająco dużo punktów",Toast.LENGTH_SHORT).show();
                                    }
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Anuluj",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.show();
                }
            }

        });
        Button lvl4 = findViewById(R.id.lvl4_r);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("C3P4")) {
                    Intent cwicznenie1 = new Intent(getApplicationContext(), Rece_poziomy.class);
                    cwicznenie1.putExtra("poziom", 4);
                    startActivity(cwicznenie1);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_rece.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 4?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //user.addItem(C3P4);
                                        //BazaDanych.setPoints(-10);
                                        Toast.makeText(getApplicationContext(),"Odblokowano poziom 4",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getApplicationContext(),"Nie masz wystraczająco dużo punktów",Toast.LENGTH_SHORT).show();
                                    }
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Anuluj",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });

                    alertDialog.show();
                }
            }

        });
        ImageButton cofnij = findViewById(R.id.lvlback_r);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}