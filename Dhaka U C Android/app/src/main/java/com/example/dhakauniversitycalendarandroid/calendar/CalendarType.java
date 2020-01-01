package com.example.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CalendarType extends AppCompatActivity {

    MaterialButton generalCalendar;
    MaterialButton specificCalendar;
    MaterialButton sportsCalendar;
    MaterialButton counselingCalendar;
    FirebaseAuth auth ;
    FirebaseUser user;
    DatabaseReference reference;
    String departmentName = "lalala";
    String academicYear = "momomo";
    boolean exist;

    boolean dataChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Calendar");
            setContentView(R.layout.activity_calendar_type);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("বর্ষপঞ্জি");
            setContentView(R.layout.activity_calendar_type_bangla);
        }
        else{
            setContentView(R.layout.activity_calendar_type);
        }

        generalCalendar = (MaterialButton) findViewById(R.id.buttongeneral);
        specificCalendar = (MaterialButton) findViewById(R.id.buttonpersonal);
        sportsCalendar = (MaterialButton) findViewById(R.id.buttonSports);
        counselingCalendar = (MaterialButton) findViewById(R.id.clubsCalendarBtn);


        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Profile").child(user.getUid());

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("department").exists()) {

                        exist = true;
                        departmentName = dataSnapshot.child("department").getValue().toString();
                        academicYear = dataSnapshot.child("academicYear").getValue().toString();

                        Log.d("department", departmentName);
                        // Toast.makeText(CalendarType.this , departmentName , Toast.LENGTH_SHORT).show();

                    }
                    else{
                        exist = false;
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    //Toast.makeText(Home2Activity.this , databaseError.getMessage() , Toast.LENGTH_SHORT).show();
                }

            });


        generalCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarType.this , CalendarClass.class);
                startActivity(intent);
            }
        });



        specificCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(CalendarType.this , CalendarSpecificClass.class);
                if(exist == false){
                    Toast.makeText(CalendarType.this,"Please update Department and Year",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    intent.putExtra("departmentName" , departmentName);
                    intent.putExtra("academicYear" , academicYear);
                    startActivity(intent);
                }


            }
        });

        sportsCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(CalendarType.this , CalendarSportsClass.class);
                startActivity(intent);

            }
        });

        counselingCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Intent intent = new Intent(CalendarType.this , CalendarCounselingClass.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();



    }
}
