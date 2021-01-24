package edu.dhaka_university_calendar.dhakauniversitycalendarandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ServerLoad extends AppCompatActivity {

    public String serverIp="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_load);

        Intent intent = getIntent();
        serverIp = intent.getStringExtra("serverip");
        String temp  = loadServer();

        Intent intent1 = new Intent(ServerLoad.this , Home2Activity.class);
        startActivity(intent1);

    }

    public String loadServer(){

        return  serverIp;
    }
}
