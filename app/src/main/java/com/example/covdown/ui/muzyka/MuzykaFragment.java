package com.example.covdown.ui.muzyka;

import com.example.covdown.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MuzykaFragment extends Fragment {


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_muzyka,container,false);

        Button muzyka1 = root.findViewById(R.id.muzykaBtn1);
        Button muzyka2 = root.findViewById(R.id.muzykaBtn2);
        Button muzyka3 = root.findViewById(R.id.muzykaBtn3);
        Button muzyka4 = root.findViewById(R.id.muzykaBtn4);
        Button muzyka5 = root.findViewById(R.id.muzykaBtn5);
        Button muzyka6 = root.findViewById(R.id.muzykaBtn6);
        Button muzyka7 = root.findViewById(R.id.muzykaBtn7);
        Button muzyka8 = root.findViewById(R.id.muzykaBtn8);
        Button muzyka9 = root.findViewById(R.id.muzykaBtn9);
        Button muzyka10 = root.findViewById(R.id.muzykaBtn10);

        muzyka1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DX2YksxITTxcW?si=b4SjH_1EStCaBJQUCw29oA");
            }
        });
        muzyka2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DWWkGXMGv9j4M?si=Ft1e43zARc6y8Dc7mb-kLw");
            }
        });
        muzyka3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DXa3FOj3Iym4D?si=x2tDo6OATweMqni1J9n9gw");
            }
        });
        muzyka4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DXdD040nrEzxm?si=BDgiyuqBQhWMcIxwubuj0w");
            }
        });
        muzyka5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DX5QPo288x03n?si=D1ooMa6hQ0ie4aIOh784Qg");
            }
        });
        muzyka6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DWVYxTSK0RENg?si=PO6LDF4qRSKfz3fLHJ23YA");
            }
        });
        muzyka7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DX6pGi5vfd9k8?si=C8NunDwOTaeRsXTbqFobKg");
            }
        });
        muzyka8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/37i9dQZF1DXakrXW5YU9SI?si=5dxCRAJrTG2S8R3qMM4UvA");
            }
        });
        muzyka9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/playlist/2ul573zB52TA6KNKHiD1dW?si=30HUfI-ZTcu2cJVPXmeI6Q");
            }
        });

        return root;



    }
    private void gotoUrl(String e) {
        Uri uri = Uri.parse(e);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}