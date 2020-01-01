package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.award;

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

public class ScholarshipsActivity extends AppCompatActivity {

    List <Scholarships> fullCommittee;
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

        Call<List<Scholarships>> call = api.getScholarships();

        call.enqueue(new Callback<List<Scholarships>>() {
            @Override
            public void onResponse(Call<List<Scholarships>> call, Response<List<Scholarships>> response) {
                final List<Scholarships> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column2_header_layout_deans_award,listView,false);
                TextView column2header1 = (TextView) headerView.findViewById(R.id.column2header1);
                column2header1.setText("Grade");
                TextView column2header2 = (TextView) headerView.findViewById(R.id.column2header2);
                column2header2.setText("Description");
                listView.addHeaderView(headerView);

                ScholarshipsListAdapter adapter = new ScholarshipsListAdapter(ScholarshipsActivity.this ,
                        R.layout.column2_row_layout_deans_award, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Scholarships>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
