package com.example.dhakauniversitycalendarandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.dhakauniversitycalendarandroid.account.Profile_Activity;
import com.example.dhakauniversitycalendarandroid.award.AwardMenuActivity;
import com.example.dhakauniversitycalendarandroid.calendar.CalendarType;
import com.example.dhakauniversitycalendarandroid.committee.CommitteeMenu;
import com.example.dhakauniversitycalendarandroid.information.InformationMenu;
import com.example.dhakauniversitycalendarandroid.map.MapMenu;
import com.example.dhakauniversitycalendarandroid.more.MoreMenuActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;

public class Home2Activity extends AppCompatActivity {

    CardView location;
    CardView profile;
    CardView calendar;
    CardView info;
    CardView committee;
    CardView credits;
    CardView award;
    CardView more;
    CardView facilities;

    boolean isEnglish ;
    String language="";

    FirebaseAuth auth ;
    FirebaseUser user;
    DatabaseReference reference;
    private FirebaseAuth.AuthStateListener mAuthListener;

    boolean dataChange = false;
    public static  final String sharedPrefs = "sharedPrefs";
    public static final String textShared = "language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs , MODE_PRIVATE);
        language = sharedPreferences.getString(textShared , " ");

        if(language.equalsIgnoreCase("english")) {
            setTitle("Home");
            setContentView(R.layout.activity_home3);
        }

        else if (language.equalsIgnoreCase("bangla")){
            setTitle("হোম");
            setContentView(R.layout.activity_home3_bangla);
        }
        else{
            setContentView(R.layout.activity_home3);
        }


        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){

                    Intent intent = new Intent(getApplicationContext() , MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
            }
        };

        calendar = findViewById(R.id.imgCalendar);
        profile = findViewById(R.id.imgProfile);
        location = findViewById(R.id.imgLocation);
        info = findViewById(R.id.imgList);
        committee = findViewById(R.id.committeeList);
        credits = findViewById(R.id.credits);
        facilities = findViewById(R.id.facilities);
        award = findViewById(R.id.award);
        more = findViewById(R.id.more);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCalendar();
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMap();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initInfo();
            }
        });

        committee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCommittee();
            }
        });

        credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCredits();
            }
        });

        award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initAward();
            }
        });

        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initMore();
            }
        });

        facilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFacilities();
            }
        });

    }


    void initCredits() {

        Intent intent = new Intent(Home2Activity.this, CreditsMenu.class);
        startActivity(intent);
    }

    void initMap()
    {
        Intent intent = new Intent(Home2Activity.this, MapMenu.class);
        startActivity(intent);
    }

    void initInfo()
    {
        Intent intent = new Intent(Home2Activity.this, InformationMenu.class);
        startActivity(intent);
    }

    void initCalendar(){

        Intent intent = new Intent(Home2Activity.this, CalendarType.class);
        startActivity(intent);
    }

    void initCommittee()
    {
        Intent intent = new Intent(Home2Activity.this, CommitteeMenu.class);
        startActivity(intent);
    }

    void initFacilities()
    {
        Intent intent = new Intent(Home2Activity.this, FacilitiesMenu.class);
        startActivity(intent);
    }

    void initAward()
    {
        Intent intent = new Intent(Home2Activity.this, AwardMenuActivity.class);
        startActivity(intent);
    }

    void initMore()
    {
        Intent intent = new Intent(Home2Activity.this, MoreMenuActivity.class);
        startActivity(intent);
    }

    public void initBack(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Really want to exit?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
                moveTaskToBack(true);
            }
        });



        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.dismiss();

            }
        });

        builder.show();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if(language.equalsIgnoreCase("bangla")){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("সত্যিই কি প্রস্থান করতে চান?");
            builder.setCancelable(false);
            builder.setPositiveButton("হ্যাঁ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    finish();
                    moveTaskToBack(true);
                }
            });

            builder.setNegativeButton("না", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which)
                {
                    dialog.dismiss();

                }
            });

            builder.show();
        }
        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Really want to exit?");
            builder.setCancelable(false);
            builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                    moveTaskToBack(true);
                }
            });


            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });

            builder.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if(language.equalsIgnoreCase("bangla")) {
            inflater.inflate(R.menu.profile_menu_bangla, menu);
        }
        else{
            inflater.inflate(R.menu.profile_menu, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile_menu:
                Intent intent2 = new Intent(Home2Activity.this , Profile_Activity.class);
                startActivity(intent2);
                break;

            case R.id.logoutitem:
                FirebaseAuth.getInstance().signOut();
                break;

            case R.id.linkItem:

                Intent downloadIntent = new Intent();
                downloadIntent.setAction(Intent.ACTION_VIEW);
                downloadIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                downloadIntent.setData(Uri.parse("https://www.du.ac.bd/download/others/Academic%20Calendar-2019%20(update).pdf"));
                startActivity(downloadIntent);
                break;

            case R.id.english:

                Intent intent = new Intent(Home2Activity.this, Home2Activity.class);
                SharedPreferences sharedPreferences = getSharedPreferences(sharedPrefs , MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(textShared , "english");
                editor.apply();

                startActivity(intent);

                //setContentView(R.layout.activity_home3);
                break;
            case R.id.bangla:

                Intent intent6 = new Intent(Home2Activity.this, Home2Activity.class);
                SharedPreferences sharedPreferences2 = getSharedPreferences(sharedPrefs , MODE_PRIVATE);
                SharedPreferences.Editor editor2 = sharedPreferences2.edit();

                editor2.putString(textShared , "bangla");
                editor2.apply();

                startActivity(intent6);

                //setContentView(R.layout.activity_home3_bangla);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }
}


