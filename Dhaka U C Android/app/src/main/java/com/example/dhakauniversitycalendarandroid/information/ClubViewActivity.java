package com.example.dhakauniversitycalendarandroid.information;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.bumptech.glide.Glide;
import com.example.dhakauniversitycalendarandroid.MovableFloatingActionButton;
import com.example.dhakauniversitycalendarandroid.R;
import com.example.dhakauniversitycalendarandroid.map.MapActivityInfrastructure;

public class ClubViewActivity extends AppCompatActivity {


    ImageView clubImage;
    TextView description;
    TextView clubName;
    MovableFloatingActionButton btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_view);

        Intent intent = getIntent();
        final Club club = (Club) intent.getSerializableExtra("clubCurrent");

        clubImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        clubName = (TextView) findViewById(R.id.name);
        btnMap = (MovableFloatingActionButton) findViewById(R.id.buttonMap);
        CoordinatorLayout.LayoutParams lp  = (CoordinatorLayout.LayoutParams) btnMap.getLayoutParams();
        btnMap.setCoordinatorLayout(lp);
        btnMap.animate();


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(ClubViewActivity.this  , MapActivityInfrastructure.class);
                intent.putExtra("longitude" ,club.getLatitude() );
                intent.putExtra("latitude" , club.getLongitude());
                intent.putExtra("name" , club.getName());
                startActivity(intent);
            }
        });

        clubName.setText(club.getName());
        description.setText(club.getDescription().trim());
        Glide.with(ClubViewActivity.this).load(club.getImage())
                .placeholder(R.drawable.dulogo).into(clubImage);


    }
}
