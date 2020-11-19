package com.example.covdown.ui.dlaCiebie;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.covdown.R;
import com.example.covdown.data.BazaSzpitali;

import org.xml.sax.ContentHandler;

import java.io.IOException;
import java.util.List;

public class DlaCiebieFragment extends Fragment /*implements View.OnClickListener*/ {

    private DlaCiebieViewModel mViewModel;
    LocationManager locationManager;
    Context context;
    double latitude;
    double longitude;

    BazaSzpitali bazaSzpitali = BazaSzpitali.get();

    View view;

    public static DlaCiebieFragment newInstance() {
        return new DlaCiebieFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.dla_ciebie_fragment, container, false);

        context=getContext();
        locationManager=(LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            isLocationEnabled();
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                2000,
                10, locationListenerGPS);

        return view;
    }

    LocationListener locationListenerGPS = new LocationListener() {
        @Override
        public void onLocationChanged(android.location.Location location) {
            latitude = location.getLatitude();
            longitude = location.getLongitude();
            String msg = Math.round(latitude) + "N  " + Math.round(longitude) + "E";

            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            // TextView textView = (TextView)findViewById(R.id.abc);
            // textView.setText(msg);
            // System.out.println("Witam");
            test();
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };


    public void onResume(){
        super.onResume();
        isLocationEnabled();
    }

    private void isLocationEnabled() {

        if(!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            AlertDialog.Builder alertDialog=new AlertDialog.Builder(context);
            alertDialog.setTitle("Enable Location");
            alertDialog.setMessage("Your locations setting is not enabled. Please enabled it in settings menu.");
            alertDialog.setPositiveButton("Location Settings", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    Intent intent=new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int which){
                    dialog.cancel();
                }
            });
            AlertDialog alert=alertDialog.create();
            alert.show();
        }
    }

    public void test(){
        Geocoder gc = new Geocoder(getContext());
        if(gc.isPresent()) {
            List<Address> list = null;
            try {
                list = gc.getFromLocation(latitude, longitude,1);
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert list != null;
            Address address = list.get(0);
            String strAddress = address.getLocality();
            TextView textView = view.findViewById(R.id.local);
            textView.setText(strAddress);

            Button callSanepid = view.findViewById(R.id.sanepid);
            TextView nazwaSzpital1 = view.findViewById(R.id.nazwaSzpitala1);
            TextView nazwaSzpital2 = view.findViewById(R.id.nazwaSzpitala2);
            TextView nazwaSzpital3 = view.findViewById(R.id.nazwaSzpitala3);
            TextView nazwaSzpital4 = view.findViewById(R.id.nazwaSzpitala4);
            TextView numerSzpital1 = view.findViewById(R.id.numerTelefonuSzpitala1);
            TextView numerSzpital2 = view.findViewById(R.id.numerTelefonuSzpitala2);
            TextView numerSzpital3 = view.findViewById(R.id.numerTelefonuSzpitala3);
            TextView numerSzpital4 = view.findViewById(R.id.numerTelefonuSzpitala4);
            ImageButton callSzpital1 = view.findViewById(R.id.numerbtn1);
            ImageButton callSzpital2 = view.findViewById(R.id.numerbtn2);
            ImageButton callSzpital3 = view.findViewById(R.id.numerbtn3);
            ImageButton callSzpital4 = view.findViewById(R.id.numerbtn4);
            ImageButton imgSzpital1 = view.findViewById(R.id.imgszpitala1);
            ImageButton imgSzpital2 = view.findViewById(R.id.imgszpitala2);
            ImageButton imgSzpital3 = view.findViewById(R.id.imgszpitala3);
            ImageButton imgSzpital4 = view.findViewById(R.id.imgszpitala4);




            if ( address.getAdminArea().equals("Lower Silesian Voivodeship") || address.getAdminArea().equals("Dolnośląskie")) {
                callSanepid.setText("713283041");
                bazaSzpitali.getSzpitale(getContext(),"Dolnoslaskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Kuyavian-Pomeranian Voivodeship") || address.getAdminArea().equals("Kujawsko-Pomorskie Voivodeship")) {
                callSanepid.setText("523761800");
                bazaSzpitali.getSzpitale(getContext(),"Kujawsko-Pomorskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Lublin Voivodeship") || address.getAdminArea().equals("Lubelskie")) {
                callSanepid.setText("817434272");
                bazaSzpitali.getSzpitale(getContext(),"Lubelskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Lubusz Voivodeship") ||address.getAdminArea().equals("Lubuskie")) {
                callSanepid.setText("957226057");
                bazaSzpitali.getSzpitale(getContext(),"Lubuskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Lódź Voivodeship") || address.getAdminArea().equals("Łódzkie")) {
                callSanepid.setText("422536200");
                bazaSzpitali.getSzpitale(getContext(),"Lodzkie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Lesser Poland Voivodeship") || address.getAdminArea().equals("Małopolskie")) {
                callSanepid.setText("122549555");
                bazaSzpitali.getSzpitale(getContext(),"Malopolskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Masovian Voivodeship") || address.getAdminArea().equals("Mazowieckie")) {
                callSanepid.setText("226209001");
                bazaSzpitali.getSzpitale(getContext(),"Mazowieckie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Opole Voivodeship") || address.getAdminArea().equals("Opolskie")) {
                callSanepid.setText("774426904");
                bazaSzpitali.getSzpitale(getContext(),"Opolskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Subcarpathian Voivodeship") || address.getAdminArea().equals("Podkarpackie")) {
                callSanepid.setText("172420112");
                bazaSzpitali.getSzpitale(getContext(),"Podkarpackie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Podlaskie Voivodeship") || address.getAdminArea().equals("Podlaskie")) {
                callSanepid.setText("857408540");
                bazaSzpitali.getSzpitale(getContext(),"Podlaskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Silesian Voivodeship")  || address.getAdminArea().equals("Śląskie")) {
                callSanepid.setText("323512300");
                bazaSzpitali.getSzpitale(getContext(),"Slaskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Świętokrzyskie Voivodeship") || address.getAdminArea().equals("Świętokrzyskie")) {
                callSanepid.setText("413655400");
                bazaSzpitali.getSzpitale(getContext(),"Swietokrzyskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Warmian-Masurian Voivodeship") || address.getAdminArea().equals("Warmińsko-Mazurskie")) {
                callSanepid.setText("222500115");
                bazaSzpitali.getSzpitale(getContext(),"Warminsko-Mazurskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Greater Poland Voivodeship") || address.getAdminArea().equals("Wielkopolskie")) {
                callSanepid.setText("222500115");
                bazaSzpitali.getSzpitale(getContext(),"Wielkopolskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("West Pomeranian Voivodeship") || address.getAdminArea().equals("Zachodniopomorskie")) {
                callSanepid.setText("914624060");
                bazaSzpitali.getSzpitale(getContext(),"Zachodniopomorskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            if ( address.getAdminArea().equals("Pomeranian Voivodeship") || address.getAdminArea().equals("Pomorskie")) {
                callSanepid.setText("422536200");
                bazaSzpitali.getSzpitale(getContext(),"Pomorskie");
                nazwaSzpital1.setText(bazaSzpitali.getSzpitale(0).getNazwa());
                nazwaSzpital2.setText(bazaSzpitali.getSzpitale(1).getNazwa());
                nazwaSzpital3.setText(bazaSzpitali.getSzpitale(2).getNazwa());
                nazwaSzpital4.setText(bazaSzpitali.getSzpitale(3).getNazwa());
                numerSzpital1.setText(bazaSzpitali.getSzpitale(0).getNumer());
                numerSzpital2.setText(bazaSzpitali.getSzpitale(1).getNumer());
                numerSzpital3.setText(bazaSzpitali.getSzpitale(2).getNumer());
                numerSzpital4.setText(bazaSzpitali.getSzpitale(3).getNumer());
            }
            callSanepid.setOnClickListener(onClickListener);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DlaCiebieViewModel.class);
        // TODO: Use the ViewModel
    }


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.sanepid){
                Button button = view.findViewById(R.id.sanepid);
                Uri number = Uri.parse("tel:"+ button.getText().toString());
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        }
    };

}
