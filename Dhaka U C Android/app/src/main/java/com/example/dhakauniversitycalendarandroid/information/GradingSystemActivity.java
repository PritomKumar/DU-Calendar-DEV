package com.example.dhakauniversitycalendarandroid.information;

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

public class GradingSystemActivity extends AppCompatActivity {

    List <GradeSystem> fullCommittee;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committe);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.tableList);

        Call<List<GradeSystem>> call = api.getGradingSystem();

        call.enqueue(new Callback<List<GradeSystem>>() {
            @Override
            public void onResponse(Call<List<GradeSystem>> call, Response<List<GradeSystem>> response) {
                final List<GradeSystem> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column3_header_layout,listView,false);
                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Marks");
                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Letter Grade");
                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Grade Point");

                listView.addHeaderView(headerView);

                GradingSystemTableListAdapter adapter = new GradingSystemTableListAdapter(GradingSystemActivity.this ,
                        R.layout.column3_row_layout, fullCommittee );


                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<GradeSystem>> call, Throwable t) {
               // Toast.makeText(ImplementationCommitteActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
