package com.example.covdown.ui.userPanel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.covdown.MainActivity;
import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;

public class UserPanel extends AppCompatActivity {

    AktywnyUzytkownik au = AktywnyUzytkownik.get();
    BazaDanych bdjqp = BazaDanych.get();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_panel);
        Button usun = findViewById(R.id.deleteAcc);
        Button wyloguj = findViewById(R.id.logout);
        TextView username = findViewById(R.id.userPanelUsername);
        final TextView userdate = findViewById(R.id.userPanelDate);
        TextView userid = findViewById(R.id.userpanelid);
        username.setText(au.getNazwa());
        userdate.setText(au.getData().toString());
        userid.setText(String.valueOf(au.get_ID()));
        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog usuwanieKonta = new AlertDialog.Builder(getApplicationContext()).create();
                usuwanieKonta.setTitle("Czy na pewno chcesz usunąc konto");
                usuwanieKonta.setMessage("Operacja ta jest nie odwracalna");
                usuwanieKonta.setButton(AlertDialog.BUTTON_NEGATIVE, "Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usuwanieKonta.dismiss();
                    }
                });
                usuwanieKonta.setButton(AlertDialog.BUTTON_POSITIVE, "Tak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        usuwanieKonta.dismiss();
                        bdjqp.deleteUserAcc();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });
                usuwanieKonta.show();
            }
        });
        wyloguj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                au.setData(null);
                au.set_ID(null);
                au.setOdblokowane(null);
                au.setNazwa(null);
                au.setIconID(null);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}