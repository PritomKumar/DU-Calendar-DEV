package com.example.dhakauniversitycalendarandroid.faculty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;
import com.example.dhakauniversitycalendarandroid.information.Department;
import com.example.dhakauniversitycalendarandroid.information.DepartmentListAdapter;
import com.example.dhakauniversitycalendarandroid.information.DepartmentViewActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FacultyBiologicalScienceInfoActivity extends AppCompatActivity {

    List<Department> list ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_info);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.departMentListView);

        Call<List<Department>> call = api.getBiologicalScienceDepartments();

        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                final List<Department> departments = response.body();

                DepartmentListAdapter departmentListAdapter = new DepartmentListAdapter(FacultyBiologicalScienceInfoActivity.this ,
                        R.layout.department_list_item ,departments );
                listView.setAdapter(departmentListAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Department departmentTemp = departments.get(position);

                       // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(FacultyBiologicalScienceInfoActivity.this , DepartmentViewActivity.class);
                        intent.putExtra("departmentCurrent" ,  departmentTemp);
                        startActivity(intent);

                    }
                });

                for(Department d : departments){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getName() );
                    Log.d("description" , d.getDescription() );
                    Log.d("image",d.getImage());
                   // Toast.makeText(FacultyBiologicalScienceInfoActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
               // Toast.makeText(FacultyBiologicalScienceInfoActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });




    }
}
