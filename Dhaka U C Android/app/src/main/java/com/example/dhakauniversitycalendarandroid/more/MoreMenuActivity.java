package com.example.dhakauniversitycalendarandroid.more;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;
import com.google.android.material.button.MaterialButton;

public class MoreMenuActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Other");
            setContentView(R.layout.activity_more_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("অন্যান্য");
            setContentView(R.layout.activity_more_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_more_menu);
        }

        MaterialButton proctorialRules = (MaterialButton) findViewById(R.id.ProtoralRules);
        proctorialRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreMenuActivity.this , ProctorialRulesActivity.class);
                startActivity(intent);
            }
        });


        MaterialButton affiliatedInstitues = (MaterialButton) findViewById(R.id.affiliatedInstitutes);
        affiliatedInstitues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreMenuActivity.this , AffiliatedInstitutesActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton ducsu = (MaterialButton) findViewById(R.id.dacsu);
        ducsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MoreMenuActivity.this , DucsuActivity.class);
                startActivity(intent);
            }
        });
    }
}
