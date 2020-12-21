package com.example.covdown.data;

import android.content.Context;

import com.example.covdown.R;

public class AktywnyUzytkownik {
    private String nazwa;
    private String iconID = "I01";

    private static AktywnyUzytkownik self = new AktywnyUzytkownik();
    public static AktywnyUzytkownik get() {return self;}
    public Itemki odblokowane;

    public void setOdblokowane(Itemki odblokowane) {
        this.odblokowane = odblokowane;
    }

    public Itemki getOdblokowane() {
        return odblokowane;
    }

    public void addItem(String kod){
        odblokowane.add(new Itemek(kod,true));
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setIconID(String iconID) {
        this.iconID = iconID;
    }

    public int setIconImage(){
        int ID = 0;
        switch (iconID){
            case "I01":
                ID = R.drawable.i01;
                break;
            case "I02":
                ID = R.drawable.i02;
                break;
            case "I03":
                ID = R.drawable.i03;
                break;
            case "I04":
                ID = R.drawable.i04;
                break;
            case "I05":
                ID = R.drawable.i05;
                break;
            case "I06":
                ID = R.drawable.i06;
                break;
            case "I07":
                ID = R.drawable.i07;
                break;
            case "I08":
                ID = R.drawable.i08;
                break;
            case "I09":
                //ID = R.drawable.i01;
                break;
        }
        return ID;
    }

}
