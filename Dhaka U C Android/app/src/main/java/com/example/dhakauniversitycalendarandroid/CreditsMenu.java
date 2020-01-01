package com.example.dhakauniversitycalendarandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.committee.EditorialCommitteActivity;
import com.example.dhakauniversitycalendarandroid.committee.ImplementationCommitteActivity;
import com.google.android.material.button.MaterialButton;

public class CreditsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Credit");
            setContentView(R.layout.activity_credits_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("কৃতিত্ব");
            setContentView(R.layout.activity_credits_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_credits_menu);
        }

        MaterialButton editorialCommittee = (MaterialButton) findViewById(R.id.editorialBtn);
        MaterialButton implementationCommittee = (MaterialButton) findViewById(R.id.implementationBtn);
        MaterialButton developres = (MaterialButton) findViewById(R.id.developer);

        editorialCommittee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditsMenu.this , EditorialCommitteActivity.class);
                startActivity(intent);
            }
        });

        implementationCommittee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditsMenu.this , ImplementationCommitteActivity.class);
                startActivity(intent);
            }
        });

        developres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreditsMenu.this , DevelopresActivity.class);
                startActivity(intent);
            }
        });

    }

}
