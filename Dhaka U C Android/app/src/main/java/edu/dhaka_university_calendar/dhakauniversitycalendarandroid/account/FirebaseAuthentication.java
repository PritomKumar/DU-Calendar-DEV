package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.account;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class FirebaseAuthentication extends Application {

    @Override
    public void onCreate() {

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        super.onCreate();
    }
}
