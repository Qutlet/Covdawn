package com.example.covdown.data;

public class Szpital {
    private String nazwa;
    private String numer;
    private String lat;
    private String lon;

    public Szpital(String nazwa, String numer, String lat, String lon) {
        this.nazwa = nazwa;
        this.numer = numer;
        this.lat = lat;
        this.lon = lon;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getNumer() {
        return numer;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
