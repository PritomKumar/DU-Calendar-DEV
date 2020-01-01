package com.example.dhakauniversitycalendarandroid.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.bumptech.glide.Glide;
import com.example.dhakauniversitycalendarandroid.R;

import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class FacultyViewActivity extends AppCompatActivity {


    ImageView facultyImage;
    TextView description;
    TextView facultyName;
    FloatingTextButton btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_view);

        Intent intent = getIntent();
        final Faculty faculty = (Faculty) intent.getSerializableExtra("departmentCurrent");

        facultyImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        facultyName = (TextView) findViewById(R.id.name);
        btnList = (FloatingTextButton) findViewById(R.id.listBtn);
        CoordinatorLayout.LayoutParams lp  = (CoordinatorLayout.LayoutParams) btnList.getLayoutParams();

        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(faculty.getName().trim().equalsIgnoreCase("Faculty of Arts") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyArtsInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Science") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyScienceInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Law") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyLawInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Business Studies") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyCommerceInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Social Sciences") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultySocialScienceInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Biological Sciences") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyBiologicalScienceInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Pharmacy") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyPharmacyInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Earth and Environmental") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyEarthInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Engineering and Technology") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyEngineeringInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Arts") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyArtsInfoActivity.class);
                    startActivity(intent);
                }

                else if(faculty.getName().trim().equalsIgnoreCase("Faculty of Fine Arts") ){
                    Intent intent =  new Intent(FacultyViewActivity.this  , FacultyFineArtsInfoActivity.class);
                    startActivity(intent);
                }

            }
        });

        facultyName.setText(faculty.getName());
        description.setText(faculty.getDescription().trim());
        Glide.with(FacultyViewActivity.this).load(faculty.getImage())
                .placeholder(R.drawable.dulogo).into(facultyImage);


    }
}
