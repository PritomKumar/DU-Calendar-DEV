package edu.dhaka_university_calendar.dhakauniversitycalendarandroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;


public class ServerIPLoad {

    public String serverIP = "" ;

    public String loadServerIP(){

        Context applicationContext = Home2Activity.getContextOfApplication();

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(applicationContext);

        serverIP = sharedPreferences.getString("serverip", "");


        Log.d("uri2" , "server ip = " + serverIP);

        return  serverIP;
    }


}
