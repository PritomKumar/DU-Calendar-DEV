package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.faculty.Faculty;

public class DuMedicalCenterViewActivity extends AppCompatActivity {

    ImageView departmentImage;
    TextView description;
    TextView departmentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_du_medical_center_view);

        Intent intent = getIntent();
        final Faculty department = (Faculty) intent.getSerializableExtra("departmentCurrent");

        departmentImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        departmentName = (TextView) findViewById(R.id.textView4);

        departmentName.setText(department.getName().trim());
        description.setText(department.getDescription().trim());
        Glide.with(DuMedicalCenterViewActivity.this).load(department.getImage())
                .placeholder(R.drawable.dulogo).into(departmentImage);


    }
}
