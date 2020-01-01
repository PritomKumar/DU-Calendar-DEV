package com.example.dhakauniversitycalendarandroid.committee;

import android.os.Bundle;
import android.util.Log;
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

public class EditorialCommitteActivity extends AppCompatActivity {

    List <CommitteMember> fullCommittee;
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

        Call<List<CommitteMember>> call = api.getEditorialCommittee();

        call.enqueue(new Callback<List<CommitteMember>>() {
            @Override
            public void onResponse(Call<List<CommitteMember>> call, Response<List<CommitteMember>> response) {
                final List<CommitteMember> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(
                        R.layout.column3_header_layout,listView,false);
                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Name");
                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Rank");
                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Membership");
                listView.addHeaderView(headerView);

                CommitteeTableListAdapter adapter = new CommitteeTableListAdapter(EditorialCommitteActivity.this ,
                        R.layout.column3_row_layout, fullCommittee );
                listView.setAdapter(adapter);

                for(CommitteMember d : fullCommittee){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getName() );
                    Log.d("rank" , d.getRank() );
                    Log.d("membership" , d.getMembership() );

                    // Toast.makeText(HallInfoActivity.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<List<CommitteMember>> call, Throwable t) {
               // Toast.makeText(EditorialCommitteActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
