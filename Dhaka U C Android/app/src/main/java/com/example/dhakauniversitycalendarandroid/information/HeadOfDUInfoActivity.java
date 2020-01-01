package com.example.dhakauniversitycalendarandroid.information;

import android.content.Intent;
import android.net.Uri;
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

public class HeadOfDUInfoActivity extends AppCompatActivity {

    List<HeadOfDU> list ;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_of_du_info_activity);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.departMentListView);

        Call<List<HeadOfDU>> call = api.getHeadOfDU();

        call.enqueue(new Callback<List<HeadOfDU>>() {
            @Override
            public void onResponse(Call<List<HeadOfDU>> call, Response<List<HeadOfDU>> response) {
                final List<HeadOfDU> duHead = response.body();

                HeadOfDuListAdapter  adapter = new HeadOfDuListAdapter(HeadOfDUInfoActivity.this ,
                        R.layout.head_of_du_list_item ,duHead );
                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // Toast.makeText(FacultyScienceInfoActivity.this , departmentTemp.getName(),Toast.LENGTH_SHORT).show();

                        HeadOfDU temp = duHead.get(position);

                        Intent downloadIntent = new Intent();
                        downloadIntent.setAction(Intent.ACTION_VIEW);
                        downloadIntent.addCategory(Intent.CATEGORY_BROWSABLE);
                        downloadIntent.setData(Uri.parse(temp.getProfileLink()));
                        startActivity(downloadIntent);
                    }
                });



                for(HeadOfDU d : duHead){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getName() );
                    Log.d("rank" , d.getRank() );
                    Log.d("image",d.getImage());
                   // Toast.makeText(HallInfoActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<HeadOfDU>> call, Throwable t) {
              //  Toast.makeText(HeadOfDUInfoActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });




    }

}
