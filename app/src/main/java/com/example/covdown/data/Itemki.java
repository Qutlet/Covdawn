package com.example.covdown.data;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Itemki {
    private ArrayList<Itemek> listaItemkow = new ArrayList<>();

    public Itemki() {
    }

    public int size() {
        return listaItemkow.size();
    }

    public Itemek get(int index) {
        return listaItemkow.get(index);
    }

    public boolean add(Itemek itemek) {
        return listaItemkow.add(itemek);
    }

    public boolean find(String kod){
        for (int i = 0; i < size(); i++) {
            if(listaItemkow.get(i).getKod().equals(kod)){
                return true;
            }
        }
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder stringBuilder =  new StringBuilder();
        for (Itemek itemek: listaItemkow) {
            stringBuilder.append(itemek.getKod());
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
