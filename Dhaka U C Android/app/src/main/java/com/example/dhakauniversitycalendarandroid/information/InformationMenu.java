package com.example.dhakauniversitycalendarandroid.information;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;
import com.example.dhakauniversitycalendarandroid.faculty.Faculty;
import com.example.dhakauniversitycalendarandroid.faculty.FacultyMenu;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InformationMenu extends AppCompatActivity {

    private MaterialButton departmentBtn;
    private MaterialButton hallBtn;
    private MaterialButton officeBtn;
    private MaterialButton historyBtn;
    private MaterialButton gradingSystem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Information");
            setContentView(R.layout.activity_information_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("তথ্য");
            setContentView(R.layout.activity_information_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_information_menu);
        }

        departmentBtn = (MaterialButton) findViewById(R.id.Department);
        hallBtn = (MaterialButton) findViewById(R.id.Hall);
        officeBtn = (MaterialButton) findViewById(R.id.Office);
        historyBtn = (MaterialButton) findViewById(R.id.duHistory);
        gradingSystem = (MaterialButton) findViewById(R.id.gradingSystem);

        gradingSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationMenu.this , GradingSystemActivity.class);
                startActivity(intent);
            }
        });

        departmentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationMenu.this , FacultyMenu.class);
                startActivity(intent);
            }
        });

        hallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationMenu.this , HallInfoActivity.class);
                startActivity(intent);
            }
        });

        officeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InformationMenu.this , OfficeInfoActivity.class);
                startActivity(intent);
            }
        });

        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl(Api.baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<List<Faculty>> call = api.getDuHistory();

                call.enqueue(new Callback<List<Faculty>>() {
                    @Override
                    public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {
                        final List<Faculty> faculties = response.body();
                        Faculty facultyTemp = faculties.get(0);

                        // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InformationMenu.this , DuHistoryViewActivity.class);
                        intent.putExtra("departmentCurrent" ,  facultyTemp);
                        startActivity(intent);
/*
                for(Faculty d : faculties){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getName() );
                    Log.d("description" , d.getDescription() );

             //       Log.d("image",d.getImage());
                   // Toast.makeText(FacultyInfoActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

                */

                    }

                    @Override
                    public void onFailure(Call<List<Faculty>> call, Throwable t) {
                       // Toast.makeText(InformationMenu.this, t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}



