package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.MainActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile_Activity extends AppCompatActivity {

    FirebaseAuth auth ;
    FirebaseUser user;
    DatabaseReference reference;
    private TextView nameText;
    private TextView emailText;
    private TextView departmentText;
    private TextView academicYearText;
    private Button updateInfo;
    private FirebaseAuth.AuthStateListener mAuthListener;

    ImageView imageView;
    String departmentName = "Please update profile";
    String academicYear = "Please update profile";

    String name = "" ;
    String email = "";
    boolean dataChange = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        nameText = (TextView) findViewById(R.id.name);
        emailText = (TextView) findViewById(R.id.email);
        departmentText = (TextView) findViewById(R.id.department);
        academicYearText = (TextView) findViewById(R.id.year);
        imageView = (ImageView) findViewById(R.id.profile_image);
        updateInfo = (Button) findViewById(R.id.updateBtn);


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

     //   Log.d("Pass" , academicYear );

        FirebaseUser user2 = FirebaseAuth.getInstance().getCurrentUser();

        if (user2 != null) {

            // Name, email address, and profile photo Url
            Uri photoUrl = user2.getPhotoUrl();

            Glide.with(Profile_Activity.this).load(photoUrl)
                    .placeholder(R.drawable.icons8_user_48).into(imageView);

            // Check if user's email is verified
            boolean emailVerified = user2.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user2.getUid();

        }


        loadData();

        updateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(Profile_Activity.this, AccountActivity.class);
               startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    public void loadData(){

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Profile").child(user.getUid());
        reference.keepSynced(true);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.child("department").exists()) {
                    name = dataSnapshot.child("name").getValue().toString();
                    email = dataSnapshot.child("email").getValue().toString();
                    departmentName = dataSnapshot.child("department").getValue().toString();
                    academicYear = dataSnapshot.child("academicYear").getValue().toString();

                    dataChange = true;
                    Log.d("bbb", departmentName);
                    getUserFromFirebase();
                    // Toast.makeText(CalendarType.this , departmentName , Toast.LENGTH_SHORT).show();
                }
                else {
                    getUserProfile();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
              //  Toast.makeText(Profile_Activity.this , databaseError.getMessage() , Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void getUserFromFirebase(){

        nameText.setText(name);
        emailText.setText(email);
        departmentText.setText(departmentName);
        academicYearText.setText(academicYear);

    }
    public void getUserProfile() {
        // [START get_user_profile]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {

            // Name, email address, and profile photo Url

            name = user.getDisplayName();
            email = user.getEmail();


            nameText.setText(name);
            emailText.setText(email);
            departmentText.setText(departmentName);
            academicYearText.setText(academicYear);

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            String uid = user.getUid();

        }
        // [END get_user_profile]
    }
}
