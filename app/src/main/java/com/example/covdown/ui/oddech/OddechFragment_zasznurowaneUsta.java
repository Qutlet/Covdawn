package com.example.covdown.ui.oddech;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
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
import com.example.covdown.ui.userPanel.UserPanel;

public class OddechFragment_zasznurowaneUsta extends AppCompatActivity {
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.usta_poziomy);
        ImageButton ikona = findViewById(R.id.activeUserIcon);
        ikona.setImageResource(user.setIconImage());
        TextView punkty = findViewById(R.id.textView2);
        punkty.setText(String.valueOf(bazaDanych.getPoints()));
        TextView title = findViewById(R.id.textViewUsta1);
        bazaDanych.downloadOwnedItems();
        TextView nazwa = findViewById(R.id.textView);
        nazwa.setText(user.getNazwa());
        ikona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userPanel = new Intent(getApplicationContext(), UserPanel.class);
                startActivity(userPanel);
            }
        });
        title.setText(R.string.ustatytul);
        Button lvl1 = findViewById(R.id.lvl1_u);
        lvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cwicznenie = new Intent(getApplicationContext(), Usta_poziomy.class);
                cwicznenie.putExtra("poziom",1);
                startActivity(cwicznenie);
            }

        });
        Button lvl2 = findViewById(R.id.lvl2_u);
        lvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("C4P2")) {
                    Intent cwicznenie = new Intent(getApplicationContext(), Usta_poziomy.class);
                    cwicznenie.putExtra("poziom", 2);
                    startActivity(cwicznenie);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_zasznurowaneUsta.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 2?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        user.addItem("C4P2");
                                        bazaDanych.addItemek("C4P2");
                                        bazaDanych.setPoints(-10);
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

        }); Button lvl3 = findViewById(R.id.lvl3_u);
        lvl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("C4P3")) {
                    Intent cwicznenie = new Intent(getApplicationContext(), Usta_poziomy.class);
                    cwicznenie.putExtra("poziom", 3);
                    startActivity(cwicznenie);
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(OddechFragment_zasznurowaneUsta.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Czy chcesz odblokować poziom 3?");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Tak",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if(bazaDanych.checkPoints(10)){
                                        user.addItem("C4P3");
                                        bazaDanych.addItemek("C4P3");
                                        bazaDanych.setPoints(-10);
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
        ImageButton cofnij = findViewById(R.id.lvlback_u);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { finish(); }});
    }
}