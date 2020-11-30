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
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            }
        });
        muzyka10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://open.spotify.com/track/79s5XnCN4TJKTVMSmOx8Ep?si=mN9BjzBcQvmIPyrTMufoag");
            boolean jp=true;
            }
        });
        return root;



    }
    private void gotoUrl(String e) {
        Uri uri = Uri.parse(e);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }
}