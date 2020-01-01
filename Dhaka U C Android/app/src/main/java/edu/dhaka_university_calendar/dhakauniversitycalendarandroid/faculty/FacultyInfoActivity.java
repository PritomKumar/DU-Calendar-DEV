package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.Api;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacultyInfoActivity extends AppCompatActivity {

    List<Faculty> list ;
    ListView listView;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_info);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.departMentListView);

        Call<List<Faculty>> call = api.getFacultyList();

        call.enqueue(new Callback<List<Faculty>>() {
            @Override
            public void onResponse(Call<List<Faculty>> call, Response<List<Faculty>> response) {
                final List<Faculty> faculties = response.body();
                
                FacultyListAdapter adapter = new FacultyListAdapter(FacultyInfoActivity.this ,
                        R.layout.faculty_list_item ,faculties );
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Faculty facultyTemp = faculties.get(position);

                        // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FacultyInfoActivity.this , FacultyViewActivity.class);
                        intent.putExtra("departmentCurrent" ,  facultyTemp);
                        startActivity(intent);

                    }
                });

                for(Faculty d : faculties){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getName() );
                    Log.d("description" , d.getDescription() );
             //       Log.d("image",d.getImage());
                   // Toast.makeText(FacultyInfoActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Faculty>> call, Throwable t) {
              //  Toast.makeText(FacultyInfoActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
