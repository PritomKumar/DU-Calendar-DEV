package com.example.dhakauniversitycalendarandroid.award;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;
import com.google.android.material.button.MaterialButton;

public class AwardMenuActivity extends AppCompatActivity {

    MaterialButton deansAward;
    MaterialButton deansAwardWinners;
    MaterialButton acheivements;
    MaterialButton scholarships;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Award");
            setContentView(R.layout.activity_award_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("পুরস্কার");
            setContentView(R.layout.activity_award_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_award_menu);
        }

        deansAward = (MaterialButton) findViewById(R.id.deansAward);
        deansAward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwardMenuActivity.this , DeansAwardActivity.class);
                startActivity(intent);
            }
        });

        deansAwardWinners = (MaterialButton) findViewById(R.id.DeansAwardWinners);
        deansAwardWinners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwardMenuActivity.this , DeansAwardWinnersActivity.class);
                startActivity(intent);
            }
        });

        acheivements = (MaterialButton) findViewById(R.id.Acheivements);
        acheivements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwardMenuActivity.this , AcheivementsActivity.class);
                startActivity(intent);
            }
        });

        scholarships = (MaterialButton) findViewById(R.id.Scholarships);
        scholarships.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AwardMenuActivity.this , ScholarshipsActivity.class);
                startActivity(intent);
            }
        });
    }
}
