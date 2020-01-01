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

public class DeansAwardWinnersActivity extends AppCompatActivity {

    List <DeansAwardWinners> fullCommittee;
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

        Call<List<DeansAwardWinners>> call = api.getDeansAwardWinners();

        call.enqueue(new Callback<List<DeansAwardWinners>>() {
            @Override
            public void onResponse(Call<List<DeansAwardWinners>> call, Response<List<DeansAwardWinners>> response) {
                final List<DeansAwardWinners> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column4_deans_award_winners_header_layout,listView,false);
                TextView column4header1 = (TextView) headerView.findViewById(R.id.column4header1);
                column4header1.setText("Name");
                TextView column4header2 = (TextView) headerView.findViewById(R.id.column4header2);
                column4header2.setText("Department");
                TextView column4header3 = (TextView) headerView.findViewById(R.id.column4header3);
                column4header3.setText("Result");
                TextView column4header4 = (TextView) headerView.findViewById(R.id.column4header4);
                column4header4.setText("Year");

                listView.addHeaderView(headerView);

                DeansAwardWinnersTableListAdapter adapter = new DeansAwardWinnersTableListAdapter(DeansAwardWinnersActivity.this ,
                        R.layout.column4_deans_award_winners_row_layout, fullCommittee );
                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<DeansAwardWinners>> call, Throwable t) {
               // Toast.makeText(DeanActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
