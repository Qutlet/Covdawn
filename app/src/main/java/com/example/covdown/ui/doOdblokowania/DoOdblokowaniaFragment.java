package com.example.covdown.ui.doOdblokowania;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.covdown.R;
import com.example.covdown.data.BazaDanych;

public class DoOdblokowaniaFragment extends Fragment {

    private DoOdblokowaniaViewModel mViewModel;
    BazaDanych bazaDanych = BazaDanych.get();

    public static DoOdblokowaniaFragment newInstance() {
        return new DoOdblokowaniaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.do_odblokowania_fragment, container, false);
        ImageButton ikon01 = root.findViewById(R.id.ikony01);
        ikon01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bazaDanych.checkPoints(10)){
                    //TODO: dodawac do usera w bazie jego odblokowane elementy
                } else {

                }
            }
        });
        ImageButton ikon02 = root.findViewById(R.id.ikony02);
        ikon02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon03 = root.findViewById(R.id.ikony03);
        ikon03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon04 = root.findViewById(R.id.ikony04);
        ikon04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon05 = root.findViewById(R.id.ikony05);
        ikon05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon06 = root.findViewById(R.id.ikony06);
        ikon06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon07 = root.findViewById(R.id.ikony07);
        ikon07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton ikon08 = root.findViewById(R.id.ikony08);
        ikon08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton tlo01 = root.findViewById(R.id.tlo01);
        tlo01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton tlo02 = root.findViewById(R.id.tlo02);
        tlo02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton tlo03 = root.findViewById(R.id.tlo03);
        tlo03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ImageButton tlo04 = root.findViewById(R.id.tlo04);
        tlo04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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