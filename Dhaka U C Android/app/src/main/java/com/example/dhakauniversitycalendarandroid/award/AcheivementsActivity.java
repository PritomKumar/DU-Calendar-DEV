package com.example.dhakauniversitycalendarandroid.award;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AcheivementsActivity extends AppCompatActivity {

    List<Acheivements> list ;
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

        Call<List<Acheivements>> call = api.getAcheivements();

        call.enqueue(new Callback<List<Acheivements>>() {
            @Override
            public void onResponse(Call<List<Acheivements>> call, Response<List<Acheivements>> response) {
                final List<Acheivements> acheivements = response.body();

                AcheivementsListAdapter acheivementListAdapter = new AcheivementsListAdapter(AcheivementsActivity.this ,
                        R.layout.department_list_item ,acheivements );
                listView.setAdapter(acheivementListAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Acheivements acheivementTemp = acheivements.get(position);

                       // Toast.makeText(FacultyScienceInfoActivity.this , acheivementTemp.getName(),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AcheivementsActivity.this , AcheivementsViewActivity.class);
                        intent.putExtra("acheivementCurrent" ,  acheivementTemp);
                        startActivity(intent);

                    }
                });

                for(Acheivements d : acheivements){
                    Log.d("id" , d.getId() );
                    Log.d("Achname" , d.getName() );
                    Log.d("description" , d.getDescription() );
                    Log.d("image",d.getImageUrl());
                 //   Toast.makeText(ExcitingPlacesActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<Acheivements>> call, Throwable t) {
              //  Toast.makeText(ExcitingPlacesActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });




    }
}
