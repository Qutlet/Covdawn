package com.example.covdown.ui.spotify;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import com.example.covdown.R;
import org.xmlpull.v1.XmlPullParser;
import java.util.Objects;

public class SpotifyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout.LayoutParams doubleMatchParentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams matchParentWrapContentParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams doubleWrapContent = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams wrapContentMatchParent = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);

        FrameLayout spotifyFrameLayout = new FrameLayout(getContext());
        spotifyFrameLayout.setLayoutParams(doubleMatchParentParams);

        ScrollView spotifyScrollView = new ScrollView(getContext());
        spotifyScrollView.setLayoutParams(doubleMatchParentParams);


        LinearLayout linearLayoutScrollView = new LinearLayout(getContext());
        linearLayoutScrollView.setLayoutParams(matchParentWrapContentParams);
        linearLayoutScrollView.setOrientation(LinearLayout.VERTICAL);

        TextView opis1 = new TextView(getContext());
        opis1.setLayoutParams(matchParentWrapContentParams);
        opis1.setText("Przykladowy tekst");
        TextView opis2 = new TextView(getContext());
        opis2.setLayoutParams(matchParentWrapContentParams);
        opis2.setText("Przykladowy tekst");
        TextView opis3 = new TextView(getContext());
        opis3.setLayoutParams(matchParentWrapContentParams);
        opis3.setText("przykladowy tekst");
        linearLayoutScrollView.addView(opis1);
        linearLayoutScrollView.addView(opis2);
        linearLayoutScrollView.addView(opis3);

        for (int i = 0; i < 2; i++) {
            CardView playlistView = new CardView(requireContext());
            doubleMatchParentParams.setMargins(0,0,0,25);
            playlistView.setLayoutParams(doubleMatchParentParams);
            doubleMatchParentParams.setMargins(0,0,0,0);

            LinearLayout playlistLayout = new LinearLayout(getContext());
            playlistLayout.setLayoutParams(doubleMatchParentParams);
            playlistLayout.setOrientation(LinearLayout.VERTICAL);

            LinearLayout playlistNameLayout = new LinearLayout(getContext());
            playlistNameLayout.setLayoutParams(doubleMatchParentParams);
            playlistNameLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView playlistName = new TextView(getContext());
            doubleWrapContent.weight = 1;
            playlistName.setLayoutParams(doubleWrapContent);
            playlistName.setText("Najlepsza Muzyka Czyni Cuda");

            playlistNameLayout.addView(playlistName);

            LinearLayout playlistInfoLayout = new LinearLayout(getContext());
            playlistInfoLayout.setLayoutParams(doubleMatchParentParams);
            playlistInfoLayout.setOrientation(LinearLayout.HORIZONTAL);

            TextView playlistInfo = new TextView(getContext());
            wrapContentMatchParent.weight = 2;
            playlistInfo.setLayoutParams(wrapContentMatchParent);
            wrapContentMatchParent.weight = 0;
            playlistInfo.setGravity(Gravity.CENTER);
            playlistInfo.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);

            ImageView playlistImage = new ImageView(getContext());
            playlistImage.setImageResource(android.R.drawable.ic_menu_call);
            playlistImage.setLayoutParams(doubleWrapContent);
            doubleWrapContent.weight = 0;

            playlistInfoLayout.addView(playlistInfo);
            playlistInfoLayout.addView(playlistImage);

            LinearLayout playlistPlayButtonLayout = new LinearLayout(getContext());
            playlistPlayButtonLayout.setLayoutParams(doubleMatchParentParams);
            playlistPlayButtonLayout.setOrientation(LinearLayout.HORIZONTAL);

            ImageButton playlistPlayButton = new ImageButton(getContext());
            doubleMatchParentParams.weight = 1;
            playlistPlayButton.setLayoutParams(doubleMatchParentParams);
            doubleMatchParentParams.weight = 0;

            playlistPlayButtonLayout.addView(playlistPlayButton);

            playlistLayout.addView(playlistNameLayout);
            playlistLayout.addView(playlistInfoLayout);
            playlistLayout.addView(playlistPlayButtonLayout);

            playlistView.addView(playlistLayout);
            linearLayoutScrollView.addView(playlistView);
        }





        spotifyScrollView.addView(linearLayoutScrollView);

        spotifyFrameLayout.addView(spotifyScrollView);


        //View root = inflater.inflate((XmlPullParser) spotifyFrameLayout,container,false);

        View root = spotifyFrameLayout;


        return root;
    }
}
