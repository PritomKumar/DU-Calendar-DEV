package edu.dhaka_university_calendar.dhakauniversitycalendarandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.faculty.FacultyScienceInfoActivity;

public class InfoOptions extends AppCompatActivity {

    private Button uploadBtn;
    private Button retrieveBtn;
    private Button updateBtn;
    private Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_options);

        uploadBtn = (Button) findViewById(R.id.uploadBtn);
        retrieveBtn = (Button) findViewById(R.id.retrieveBtn);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoOptions.this , InfoActivity.class);
                startActivity(intent);
            }
        });

        retrieveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoOptions.this , FacultyScienceInfoActivity.class);
                startActivity(intent);
            }
        });


    }
}
