package com.example.covdown.data;

public class AktywnyUzytkownik {
    private String nazwa;

    private static AktywnyUzytkownik self = new AktywnyUzytkownik();
    public static AktywnyUzytkownik get() {return self;}

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
