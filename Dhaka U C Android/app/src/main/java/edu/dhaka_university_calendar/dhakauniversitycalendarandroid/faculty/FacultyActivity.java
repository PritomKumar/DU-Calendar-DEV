package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FacultyActivity extends AppCompatActivity {


    private Button science;
    private Button arts;
    private Button commerce;
    private Button institutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Profile").child(user.getUid());

        science = (Button) findViewById(R.id.scienceBtn);
        commerce = (Button) findViewById(R.id.commerceBtn);
        arts = (Button) findViewById(R.id.artsBtn);
        institutes = (Button) findViewById(R.id.institutesBtn);

        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyActivity.this , FacultyScienceInfoActivity.class);
                startActivity(intent);
            }
        });

        commerce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyActivity.this , FacultyCommerceInfoActivity.class);
                startActivity(intent);
            }
        });

        arts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyActivity.this , FacultyArtsInfoActivity.class);
                startActivity(intent);
            }
        });



    }
}
