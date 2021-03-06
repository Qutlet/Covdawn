package com.example.covdown.ui.doOdblokowania;

import androidx.annotation.IntegerRes;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.covdown.CovdownMain;
import com.example.covdown.MainActivity;
import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;
import com.example.covdown.ui.userPanel.UserPanel;

public class DoOdblokowaniaFragment extends Fragment {

    private DoOdblokowaniaViewModel mViewModel;
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik user = AktywnyUzytkownik.get();

    public static DoOdblokowaniaFragment newInstance() {
        return new DoOdblokowaniaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        bazaDanych.downloadOwnedItems();
        View root = inflater.inflate(R.layout.do_odblokowania_fragment, container, false);
        ImageButton ikon01 = root.findViewById(R.id.ikony01);
        final ImageButton ikona = getActivity().findViewById(R.id.activeUserIcon);
        final TextView punkty = getActivity().findViewById(R.id.textView2);
        ikon01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (user.getOdblokowane().find("I01")){
                   ikona.setImageResource(R.drawable.i01);
                   user.setIconID("I01");
                   bazaDanych.setIconID("I01");
               } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(0)){
                                        user.addItem("I01");
                                        bazaDanych.addItemek("I01");
                                        bazaDanych.setPoints(0);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon02 = root.findViewById(R.id.ikony02);
        ikon02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I02")){
                    ikona.setImageResource(R.drawable.i02);
                    user.setIconID("I02");
                    bazaDanych.setIconID("I02");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(5)){
                                        user.addItem("I02");
                                        bazaDanych.addItemek("I02");
                                        bazaDanych.setPoints(-5);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon03 = root.findViewById(R.id.ikony03);
        ikon03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I03")){
                    ikona.setImageResource(R.drawable.i03);
                    user.setIconID("I03");
                    bazaDanych.setIconID("I03");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(10)){
                                        user.addItem("I03");
                                        bazaDanych.addItemek("I03");
                                        bazaDanych.setPoints(-10);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon04 = root.findViewById(R.id.ikony04);
        ikon04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I04")){
                    ikona.setImageResource(R.drawable.i04);
                    user.setIconID("I04");
                    bazaDanych.setIconID("I04");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(15)){
                                        user.addItem("I04");
                                        bazaDanych.addItemek("I04");
                                        bazaDanych.setPoints(-15);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon05 = root.findViewById(R.id.ikony05);
        ikon05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I05")){
                    ikona.setImageResource(R.drawable.i05);
                    user.setIconID("I05");
                    bazaDanych.setIconID("I05");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(20)){
                                        user.addItem("I05");
                                        bazaDanych.addItemek("I05");
                                        bazaDanych.setPoints(-20);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon06 = root.findViewById(R.id.ikony06);
        ikon06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I06")){
                    ikona.setImageResource(R.drawable.i06);
                    user.setIconID("I06");
                    bazaDanych.setIconID("I06");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(25)){
                                        user.addItem("I06");
                                        bazaDanych.addItemek("I06");
                                        bazaDanych.setPoints(-25);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon07 = root.findViewById(R.id.ikony07);
        ikon07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I07")){
                    ikona.setImageResource(R.drawable.i07);
                    user.setIconID("I07");
                    bazaDanych.setIconID("I06");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(30)){
                                        user.addItem("I07");
                                        bazaDanych.addItemek("I07");
                                        bazaDanych.setPoints(-30);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        ImageButton ikon08 = root.findViewById(R.id.ikony08);
        ikon08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("I08")){
                    ikona.setImageResource(R.drawable.i08);
                    user.setIconID("I08");
                    bazaDanych.setIconID("I08");
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Nie posiadany element");
                    alertDialog.setMessage("Czy chcesz odblokować tą ikonę");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(35)){
                                        user.addItem("I08");
                                        bazaDanych.addItemek("I08");
                                        bazaDanych.setPoints(-35);
                                        punkty.setText(String.valueOf(bazaDanych.getPoints()));
                                        Toast.makeText(getContext(),"Odblokowano ikone",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te ikone",Toast.LENGTH_SHORT).show();
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
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DoOdblokowaniaViewModel.class);
        // TODO: Use the ViewModel
    }

}