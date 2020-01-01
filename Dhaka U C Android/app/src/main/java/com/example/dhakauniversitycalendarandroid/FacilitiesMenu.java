package com.example.dhakauniversitycalendarandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.faculty.Faculty;
import com.example.dhakauniversitycalendarandroid.information.ClubInfoActivity;
import com.example.dhakauniversitycalendarandroid.information.DULibraryViewActivity;
import com.example.dhakauniversitycalendarandroid.information.DuMedicalCenterViewActivity;
import com.example.dhakauniversitycalendarandroid.transport.TransportMenu;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacilitiesMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Facilities");
            setContentView(R.layout.activity_facilities_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("সু্যোগ - সুবিধা");
            setContentView(R.layout.activity_facilities_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_facilities_menu);
        }
        MaterialButton clubBtn = (MaterialButton) findViewById(R.id.Club);
        clubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesMenu.this , ClubInfoActivity.class);
                startActivity(intent);
            }
        });

        MaterialButton transportBtn = (MaterialButton) findViewById(R.id.credits);
        transportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacilitiesMenu.this , TransportMenu.class);
                startActivity(intent);
            }
        });

        MaterialButton libraryBtn = (MaterialButton) findViewById(R.id.library);
        libraryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl(Api.baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<List<Faculty>> call = api.getLibrary();

                call.enqueue(new Callback<List<Faculty>>() {
                    @Override
                    public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {
                        final List<Faculty> faculties = response.body();
                        Faculty facultyTemp = faculties.get(0);

                        // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FacilitiesMenu.this , DULibraryViewActivity.class);
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

        MaterialButton medical = (MaterialButton) findViewById(R.id.medicalCenter);
        medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit =  new Retrofit.Builder()
                        .baseUrl(Api.baseURL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                Api api = retrofit.create(Api.class);

                Call<List<Faculty>> call = api.getMedicalCenter();

                call.enqueue(new Callback<List<Faculty>>() {
                    @Override
                    public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {
                        final List<Faculty> faculties = response.body();
                        Faculty facultyTemp = faculties.get(0);

                        // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FacilitiesMenu.this , DuMedicalCenterViewActivity.class);
                        intent.putExtra("departmentCurrent" ,  facultyTemp);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(Call<List<Faculty>> call, Throwable t) {
                        // Toast.makeText(InformationMenu.this, t.getMessage() , Toast.LENGTH_SHORT).show();
                    }
                });
            }


        });
    }
}
