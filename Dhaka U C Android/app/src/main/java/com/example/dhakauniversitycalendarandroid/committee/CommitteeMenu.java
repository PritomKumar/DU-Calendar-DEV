package com.example.dhakauniversitycalendarandroid.committee;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;
import com.example.dhakauniversitycalendarandroid.information.HeadOfDUInfoActivity;
import com.google.android.material.button.MaterialButton;

public class CommitteeMenu extends AppCompatActivity {

    private MaterialButton dean;
    private MaterialButton chairmanOfDepartments;
    private MaterialButton directorOfInstitutes;
    private MaterialButton boardOfproctors;
    private MaterialButton provostOfhall;
    private MaterialButton headOfOffices;
    private MaterialButton directorOfBureaus;
    private MaterialButton head;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Authority");
            setContentView(R.layout.activity_committee_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("কর্তাব্যক্তি");
            setContentView(R.layout.activity_committee_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_committee_menu);
        }


        head = (MaterialButton) findViewById(R.id.headOfDU);
        dean = (MaterialButton) findViewById(R.id.deanBtn);
        chairmanOfDepartments = (MaterialButton) findViewById(R.id.chairmanOfDepartmentsBtn);
        directorOfInstitutes = (MaterialButton) findViewById(R.id.directorOfInstitutesBtn);
        boardOfproctors = (MaterialButton) findViewById(R.id.boardOfProctorBtn);
        provostOfhall = (MaterialButton) findViewById(R.id.provostOfHallBtn);
        headOfOffices = (MaterialButton) findViewById(R.id.headOfOfficesBtn);
        directorOfBureaus = (MaterialButton) findViewById(R.id.directorOfTheBureausAndResearchCenterBtn);

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , HeadOfDUInfoActivity.class);
                startActivity(intent);
            }
        });

        dean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , DeanActivity.class);
                startActivity(intent);
            }
        });

        chairmanOfDepartments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , ChairmanOfDepartmentsActivity.class);
                startActivity(intent);
            }
        });

        directorOfInstitutes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , DirectorOfInstitutesActivity.class);
                startActivity(intent);
            }
        });

        boardOfproctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , BoardOfProctorActivity.class);
                startActivity(intent);
            }
        });

        provostOfhall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , ProvostOfHallsActivity.class);
                startActivity(intent);
            }
        });

        headOfOffices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , HeadOfOfficesActivity.class);
                startActivity(intent);
            }
        });

        directorOfBureaus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CommitteeMenu.this , DirectorOfBureausActivity.class);
                startActivity(intent);
            }
        });

    }
}
