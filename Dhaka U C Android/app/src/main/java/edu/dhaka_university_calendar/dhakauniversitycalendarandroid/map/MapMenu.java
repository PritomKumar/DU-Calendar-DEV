package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.map;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import com.google.android.material.button.MaterialButton;

public class MapMenu extends AppCompatActivity {

    MaterialButton excitingPlaces;
    MaterialButton seeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs" , MODE_PRIVATE);
        String language = sharedPreferences.getString("language" , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Map");
            setContentView(R.layout.activity_map_menu);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("মানচিত্র");
            setContentView(R.layout.activity_map_menu_bangla);
        }
        else{
            setContentView(R.layout.activity_map_menu);
        }

        excitingPlaces = (MaterialButton) findViewById(R.id.excitingPlacesBtn);
        seeMap = (MaterialButton) findViewById(R.id.seeMapBtn);

        excitingPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapMenu.this , ExcitingPlacesActivity.class);
                startActivity(intent);
            }
        });

        seeMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapMenu.this , Map_Activity.class);
                startActivity(intent);
            }
        });
    }
}
