package com.example.dhakauniversitycalendarandroid.award;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.dhakauniversitycalendarandroid.R;

public class AcheivementsViewActivity extends AppCompatActivity {

    ImageView acheivementImage;
    TextView description;
    TextView acheivementName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acheivements_view);

        Intent intent = getIntent();
        final Acheivements acheivement = (Acheivements) intent.getSerializableExtra("acheivementCurrent");

        acheivementImage = (ImageView) findViewById(R.id.image);
        description = (TextView) findViewById(R.id.description);
        acheivementName = (TextView) findViewById(R.id.name);

        acheivementName.setText(acheivement.getName());
        description.setText(acheivement.getDescription().trim());
        Glide.with(AcheivementsViewActivity.this).load(acheivement.getImageUrl())
                .placeholder(R.drawable.dulogo).into(acheivementImage);


    }
}
