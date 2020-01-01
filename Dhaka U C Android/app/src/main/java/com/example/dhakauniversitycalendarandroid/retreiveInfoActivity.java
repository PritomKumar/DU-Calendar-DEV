package com.example.dhakauniversitycalendarandroid;

import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;

import java.util.ArrayList;
import java.util.List;

public class retreiveInfoActivity extends AppCompatActivity {

    private  static  final int PICK_IMAGE_REQUEST = 1;
    EditText departmentName;
    EditText description;
    TextView descriptionTitle;
    Button upload;
    Button imageChoser;
    private ProgressBar mProgressBar;
    private ImageView departmentImage;
    private Uri mImageUri;
    DatabaseReference databaseDepartment;
    FirebaseDatabase mFirebaseDatabase;
    StorageReference mStorageReference;
    private StorageTask mUploadTask;
    private List<DepartmentInfo> departmentInfoList;
    private RecyclerView recyclerView;
    private  ImageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retreive_info);

        FirebaseDatabase database = FirebaseDatabase.getInstance();

        departmentName  = (EditText) findViewById(R.id.name);
        description = (EditText) findViewById(R.id.Description);
        descriptionTitle = (TextView) findViewById(R.id.DescriptionTitle);
        upload = (Button) findViewById(R.id.Upload);
        departmentImage = (ImageView) findViewById(R.id.image);
        imageChoser = (Button) findViewById(R.id.chosebutton);
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        departmentInfoList = new ArrayList<DepartmentInfo>();

        mStorageReference = FirebaseStorage.getInstance().getReference("Departments/-LcxxfRbQoL_eFyYiFR3");

        databaseDepartment = FirebaseDatabase.getInstance().getReference("Departments/-Lcyd6Ngtxe2cXXr1NfJ");

        databaseDepartment.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            /*
                DepartmentInfo departmentInfo = dataSnapshot.getValue(DepartmentInfo.class);
                departmentName.setText(departmentInfo.getDepartmentName());
                description.setText(departmentInfo.getDescription());
                Picasso.get().load(departmentInfo.getmImageUrl())
                        .fit()
                        .placeholder(R.drawable.dhaka_university_logo)
                        .centerCrop().into(departmentImage);

            */

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    DepartmentInfo departmentInfo = postSnapshot.getValue(DepartmentInfo.class);
                    departmentInfoList.add(departmentInfo);
                }
                //creating adapter
                mAdapter = new ImageAdapter(getApplicationContext(), departmentInfoList);

                //adding adapter to recyclerview
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
              //  Toast.makeText(retreiveInfoActivity.this,databaseError.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });





    }

}
