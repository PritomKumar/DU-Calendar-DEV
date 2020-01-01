package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.more;

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

public class ProctorialRulesActivity extends AppCompatActivity {

    List <ProctorialRules> fullCommittee;
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

        Call<List<ProctorialRules>> call = api.getProctorialRules();

        call.enqueue(new Callback<List<ProctorialRules>>() {
            @Override
            public void onResponse(Call<List<ProctorialRules>> call, Response<List<ProctorialRules>> response) {
                final List<ProctorialRules> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column1_header_layout,listView,false);
                TextView column1header1 = (TextView) headerView.findViewById(R.id.column1header1);
                column1header1.setText("Rule");
                listView.addHeaderView(headerView);

                ProctorialRulesListAdapter adapter = new ProctorialRulesListAdapter(ProctorialRulesActivity.this ,
                        R.layout.column1_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ProctorialRules>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
