package com.example.dhakauniversitycalendarandroid.map;

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
import com.example.dhakauniversitycalendarandroid.information.Department;

public class ExcitingPlacesViewActivity extends AppCompatActivity {

    ImageView departmentImage;
    TextView description;
    TextView departmentName;
    MovableFloatingActionButton btnMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exciting_places_view);

        Intent intent = getIntent();
        final Department department = (Department) intent.getSerializableExtra("departmentCurrent");

        departmentImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        departmentName = (TextView) findViewById(R.id.name);
        btnMap = (MovableFloatingActionButton) findViewById(R.id.buttonMap);
        CoordinatorLayout.LayoutParams lp  = (CoordinatorLayout.LayoutParams) btnMap.getLayoutParams();
        btnMap.setCoordinatorLayout(lp);



        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(ExcitingPlacesViewActivity.this  , MapActivityInfrastructure.class);
                intent.putExtra("longitude" ,department.getLatitude() );
                intent.putExtra("latitude" , department.getLongitude());
                intent.putExtra("name" , department.getName());
                startActivity(intent);
            }
        });

        departmentName.setText(department.getName());
        description.setText(department.getDescription().trim());
        Glide.with(ExcitingPlacesViewActivity.this).load(department.getImage())
                .placeholder(R.drawable.dulogo).into(departmentImage);


    }

}
