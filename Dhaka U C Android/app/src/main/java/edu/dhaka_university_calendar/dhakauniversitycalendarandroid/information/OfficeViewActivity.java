package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.bumptech.glide.Glide;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.MovableFloatingActionButton;
import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.map.MapActivityInfrastructure;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

public class OfficeViewActivity extends AppCompatActivity {


    ImageView officeImage;
    TextView description;
    TextView officeName;
    MovableFloatingActionButton btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_view);

        Intent intent = getIntent();
        final Office office = (Office) intent.getSerializableExtra("officeCurrent");

        officeImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        officeName = (TextView) findViewById(R.id.name);
        btnMap = (MovableFloatingActionButton) findViewById(R.id.buttonMap);
        CoordinatorLayout.LayoutParams lp  = (CoordinatorLayout.LayoutParams) btnMap.getLayoutParams();
        btnMap.setCoordinatorLayout(lp);
        btnMap.animate();


        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(OfficeViewActivity.this  , MapActivityInfrastructure.class);
                intent.putExtra("longitude" ,office.getLatitude() );
                intent.putExtra("latitude" , office.getLongitude());
                intent.putExtra("name" , office.getName());
                startActivity(intent);
            }
        });

        officeName.setText(office.getName());
        description.setText(office.getDescription().trim());
        description.setMovementMethod(new ScrollingMovementMethod());
        Glide.with(OfficeViewActivity.this).load(office.getImage())
                .placeholder(R.drawable.dulogo).into(officeImage);


    }
}
