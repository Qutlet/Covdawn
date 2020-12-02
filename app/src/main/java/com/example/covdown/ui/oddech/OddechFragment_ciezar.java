package com.example.covdown.ui.oddech;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;


public class OddechFragment_ciezar extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poziomy_ciezar);
        bazaDanych.downloadOwnedItems();
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
                if (user.getOdblokowane().find("C1P2")) {
                    Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                    cwicznenie.putExtra("poziom", 2);
                    startActivity(cwicznenie);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_ciezar.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 2?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //BazaDanych.addItem(C1P2);
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

        }); Button lvl3 = findViewById(R.id.lvl3);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("C1P3")) {
                    Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                    cwicznenie.putExtra("poziom", 3);
                    startActivity(cwicznenie);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_ciezar.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 3?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //BazaDanych.addItem(C1P3);
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

        }); Button lvl4 = findViewById(R.id.lvl4);
        lvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getOdblokowane().find("C1P4")) {
                    Intent cwicznenie = new Intent(getApplicationContext(), Ciezar_poziomy.class);
                    cwicznenie.putExtra("poziom", 4);
                    startActivity(cwicznenie);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_ciezar.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 4?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        //BazaDanych.addItem(C1P4);
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
        ImageButton cofnij = findViewById(R.id.lvlback);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}
