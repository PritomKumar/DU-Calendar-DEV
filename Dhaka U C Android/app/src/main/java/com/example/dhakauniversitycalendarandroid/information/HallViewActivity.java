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

public class HallViewActivity extends AppCompatActivity {


    ImageView hallImage;
    TextView description;
    TextView hallName;
    MovableFloatingActionButton btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_view);

        Intent intent = getIntent();
        final Hall hall = (Hall) intent.getSerializableExtra("hallCurrent");

        hallImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        hallName = (TextView) findViewById(R.id.name);
        btnMap = (MovableFloatingActionButton) findViewById(R.id.buttonMap);
        CoordinatorLayout.LayoutParams lp  = (CoordinatorLayout.LayoutParams) btnMap.getLayoutParams();
        btnMap.setCoordinatorLayout(lp);
        btnMap.animate();


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(HallViewActivity.this  , MapActivityInfrastructure.class);
                intent.putExtra("longitude" ,hall.getLatitude() );
                intent.putExtra("latitude" , hall.getLongitude());
                intent.putExtra("name" , hall.getName());
                startActivity(intent);
            }
        });

        hallName.setText(hall.getName());
        description.setText(hall.getDescription().trim());
  //      description.setMovementMethod(new ScrollingMovementMethod());
        Glide.with(HallViewActivity.this).load(hall.getImage())
                .placeholder(R.drawable.dulogo).into(hallImage);


    }
}
