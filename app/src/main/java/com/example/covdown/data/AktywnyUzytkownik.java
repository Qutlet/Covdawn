package com.example.covdown.data;

public class AktywnyUzytkownik {
    BazaDanych bazaDanych = BazaDanych.get();
    private String nazwa;

    private static AktywnyUzytkownik self = new AktywnyUzytkownik();
    public static AktywnyUzytkownik get() {return self;}
    public Itemki odblokowane;

    public void setOdblokowane(Itemki odblokowane) {
        this.odblokowane = odblokowane;
    }

    public Itemki getOdblokowane() {
        return odblokowane;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
