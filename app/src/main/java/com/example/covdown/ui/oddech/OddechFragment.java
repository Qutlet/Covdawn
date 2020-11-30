package com.example.covdown.ui.oddech;

import androidx.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.example.covdown.R;
import com.example.covdown.data.AktywnyUzytkownik;
import com.example.covdown.data.BazaDanych;
import com.example.covdown.data.Itemki;

public class OddechFragment extends Fragment implements View.OnClickListener {

    private OddechViewModel mViewModel;
    BazaDanych bazaDanych = BazaDanych.get();
    AktywnyUzytkownik aktywnyUzytkownik = AktywnyUzytkownik.get();
    Itemki odblkowoane = bazaDanych.downloadOwnedItems(aktywnyUzytkownik.getNazwa());
    View view;

    public static OddechFragment newInstance() {
        return new OddechFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.oddech_fragment, container, false);

        ImageButton zasznurowaneUsta = view.findViewById(R.id.zasznurowaneUsta);
        ImageButton cwiczeniaZButelka = view.findViewById(R.id.cwiczenieZButelka);
        ImageButton oddechCiezar = view.findViewById(R.id.oddychanieZCiezarem);
        ImageButton rece = view.findViewById(R.id.receGoraDol);
        ImageButton uspokojenie = view.findViewById(R.id.uspokajajace);
        zasznurowaneUsta.setOnClickListener(this);
        cwiczeniaZButelka.setOnClickListener(this);
        oddechCiezar.setOnClickListener(this);
        rece.setOnClickListener(this);
        uspokojenie.setOnClickListener(this);
        System.out.println(odblkowoane.get(0).getKod());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mViewModel = ViewModelProviders.of(this).get(OddechViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.zasznurowaneUsta){
            Intent zasznurowaneUsta = new Intent(getContext(),OddechFragment_zasznurowaneUsta.class);
            startActivity(zasznurowaneUsta);
        }
        if (v.getId() == R.id.cwiczenieZButelka){
            Intent cwiczenieZButelka = new Intent(getContext(),OddechFragment_butelka.class);
            startActivity(cwiczenieZButelka);
        }
        if (v.getId() == R.id.oddychanieZCiezarem){
            //if (odblkowoane.find("C03")) {
                Intent oddychanieZCiezarem = new Intent(getContext(), OddechFragment_ciezar.class);
                startActivity(oddychanieZCiezarem);
           // }else {
              //  System.out.println("Nie posiadasz tego elementu");
           // }
        }
        if (v.getId() == R.id.receGoraDol){
            System.out.println(odblkowoane.toString());
            if (odblkowoane.find("C02")){
                Intent receGoraDol = new Intent(getContext(),OddechFragment_rece.class);
                startActivity(receGoraDol);
            } else {
                System.out.println("Nie posiadasz tego elementu");
            }

        }
        if (v.getId() == R.id.uspokajajace){
            Intent uspokajajace = new Intent(getContext(),OddechFragment_uspokujsie.class);
            startActivity(uspokajajace);
        }
    }
}