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

public class BoardOfProctorActivity extends AppCompatActivity {

    List <BoardOfProctor> fullCommittee;
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

        Call<List<BoardOfProctor>> call = api.getBoardOfProctor();

        call.enqueue(new Callback<List<BoardOfProctor>>() {
            @Override
            public void onResponse(Call<List<BoardOfProctor>> call, Response<List<BoardOfProctor>> response) {
                final List<BoardOfProctor> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column3_header_layout,listView,false);
                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Name");
                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Institute");
                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Membership");
                listView.addHeaderView(headerView);

                BoardOfProctorListAdapter adapter = new BoardOfProctorListAdapter(BoardOfProctorActivity.this ,
                        R.layout.column3_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<BoardOfProctor>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
