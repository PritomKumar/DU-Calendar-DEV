package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information.InstituesInfoActivity;

public class FacultyMenu extends AppCompatActivity {

    private CardView faculty;
    private CardView institutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_menu);


        faculty = (CardView) findViewById(R.id.facultyBtn);
        institutes = (CardView) findViewById(R.id.institutesBtn);

        faculty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyMenu.this , FacultyInfoActivity.class);
                startActivity(intent);
            }
        });

        institutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyMenu.this , InstituesInfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
