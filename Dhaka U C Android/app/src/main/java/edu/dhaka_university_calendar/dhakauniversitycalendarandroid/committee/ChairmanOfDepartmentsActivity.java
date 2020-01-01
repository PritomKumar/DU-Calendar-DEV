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

public class ChairmanOfDepartmentsActivity extends AppCompatActivity {

    List <ChairmanOfDepartments> fullCommittee;
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

        Call<List<ChairmanOfDepartments>> call = api.getChairmanOfDepartments();

        call.enqueue(new Callback<List<ChairmanOfDepartments>>() {
            @Override
            public void onResponse(Call<List<ChairmanOfDepartments>> call, Response<List<ChairmanOfDepartments>> response) {
                final List<ChairmanOfDepartments> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column2_header_layout,listView,false);
                TextView column2header1 = (TextView) headerView.findViewById(R.id.column2header1);
                column2header1.setText("Department");
                TextView column2header2 = (TextView) headerView.findViewById(R.id.column2header2);
                column2header2.setText("Chairman");
                listView.addHeaderView(headerView);

                ChairmanOfDepartmentsListAdapter adapter = new ChairmanOfDepartmentsListAdapter(ChairmanOfDepartmentsActivity.this ,
                        R.layout.column2_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<ChairmanOfDepartments>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
