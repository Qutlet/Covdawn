package com.example.covdown.ui.doOdblokowania;

import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;

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
        ikon01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (user.getOdblokowane().find("I01")){
                   //zmienic ikone usera
               } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(0)){
                                        user.addItem("I01");
                                        bazaDanych.setPoints(0);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(5)){
                                        user.addItem("I02");
                                        bazaDanych.setPoints(-5);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(10)){
                                        user.addItem("I03");
                                        bazaDanych.setPoints(-10);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(15)){
                                        user.addItem("I04");
                                        bazaDanych.setPoints(-15);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(20)){
                                        user.addItem("I05");
                                        bazaDanych.setPoints(-20);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(25)){
                                        user.addItem("I06");
                                        bazaDanych.setPoints(-25);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(30)){
                                        user.addItem("I07");
                                        bazaDanych.setPoints(-30);
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
                    //zmienic ikone usera
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(35)){
                                        user.addItem("I08");
                                        bazaDanych.setPoints(-35);
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
        ImageButton tlo01 = root.findViewById(R.id.tlo01);
        tlo01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("T01")){
                    //zmienic tlo
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(0)){
                                        user.addItem("T01");
                                        bazaDanych.setPoints(0);
                                        Toast.makeText(getContext(),"Odblokowano tlo",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te tlo",Toast.LENGTH_SHORT).show();
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
        ImageButton tlo02 = root.findViewById(R.id.tlo02);
        tlo02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("T02")){
                    //zmienic tlo
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(10)){
                                        user.addItem("T02");
                                        bazaDanych.setPoints(-10);
                                        Toast.makeText(getContext(),"Odblokowano tlo",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te tlo",Toast.LENGTH_SHORT).show();
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
        ImageButton tlo03 = root.findViewById(R.id.tlo03);
        tlo03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("T03")){
                    //zmienic tlo
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(20)){
                                        user.addItem("T03");
                                        bazaDanych.setPoints(-20);
                                        Toast.makeText(getContext(),"Odblokowano tlo",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te tlo",Toast.LENGTH_SHORT).show();
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
        ImageButton tlo04 = root.findViewById(R.id.tlo04);
        tlo04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user.getOdblokowane().find("T04")){
                    //zmienic tlo
                } else {
                    AlertDialog alertDialog = new AlertDialog.Builder(getContext()).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Alert message to be shown");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    if (bazaDanych.checkPoints(40)){
                                        user.addItem("T04");
                                        bazaDanych.setPoints(-40);
                                        Toast.makeText(getContext(),"Odblokowano tlo",Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(getContext(),"Nie stac Cie biedaku na te tlo",Toast.LENGTH_SHORT).show();
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