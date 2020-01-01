package com.example.dhakauniversitycalendarandroid.committee;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeadOfOfficesActivity extends AppCompatActivity {

    List <HeadOfOffice> fullCommittee;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dean);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.tableList);

        Call<List<HeadOfOffice>> call = api.getHeadOfOffices();

        call.enqueue(new Callback<List<HeadOfOffice>>() {
            @Override
            public void onResponse(Call<List<HeadOfOffice>> call, Response<List<HeadOfOffice>> response) {
                final List<HeadOfOffice> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column2_header_layout,listView,false);
                TextView column2header1 = (TextView) headerView.findViewById(R.id.column2header1);
                column2header1.setText("Office Name");
                TextView column2header2 = (TextView) headerView.findViewById(R.id.column2header2);
                column2header2.setText("Office Head");
                listView.addHeaderView(headerView);

                HeadOfOfficesTableListAdapter adapter = new HeadOfOfficesTableListAdapter(HeadOfOfficesActivity.this ,
                        R.layout.column2_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<HeadOfOffice>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
