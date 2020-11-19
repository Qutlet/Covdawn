package com.example.covdown.data;

public class Itemek {

    private String kod;
    private boolean stanPosiadania;

    public Itemek(String kod, boolean stanPosiadania) {
        this.kod = kod;
        this.stanPosiadania = stanPosiadania;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public boolean isStanPosiadania() {
        return stanPosiadania;
    }

    public void setStanPosiadania(boolean stanPosiadania) {
        this.stanPosiadania = stanPosiadania;
    }
}
