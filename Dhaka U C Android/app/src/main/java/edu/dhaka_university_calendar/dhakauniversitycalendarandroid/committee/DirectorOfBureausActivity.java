package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.committee;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.Api;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DirectorOfBureausActivity extends AppCompatActivity {

    List <DirectorOfBureaus> fullCommittee;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        setContentView(R.layout.activity_dean);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.tableList);

        Call<List<DirectorOfBureaus>> call = api.getDirectorOfBureaus();

        call.enqueue(new Callback<List<DirectorOfBureaus>>() {
            @Override
            public void onResponse(Call<List<DirectorOfBureaus>> call, Response<List<DirectorOfBureaus>> response) {
                final List<DirectorOfBureaus> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column5_header_layout,listView,false);
                TextView column5header1 = (TextView) headerView.findViewById(R.id.column5header1);
                column5header1.setText("Name of the research center");
                TextView column5header2 = (TextView) headerView.findViewById(R.id.column5header2);
                column5header2.setText("Dean of the constitution");
                TextView column5header3 = (TextView) headerView.findViewById(R.id.column5header3);
                column5header3.setText("Managing committee date");
                TextView column5header4 = (TextView) headerView.findViewById(R.id.column5header4);
                column5header4.setText("Chairman name and date of Appoinment");
                TextView column5header5 = (TextView) headerView.findViewById(R.id.column5header5);
                column5header5.setText("Director name and date of appoinment");

                listView.addHeaderView(headerView);

                DirectorOfBureausTableListAdapter adapter = new DirectorOfBureausTableListAdapter(DirectorOfBureausActivity.this ,
                        R.layout.column5_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<DirectorOfBureaus>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
