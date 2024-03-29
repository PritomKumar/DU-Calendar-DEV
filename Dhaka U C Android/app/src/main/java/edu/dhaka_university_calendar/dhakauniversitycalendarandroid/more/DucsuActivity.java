package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.more;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.Api;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DucsuActivity extends AppCompatActivity {

    List <Ducsu> fullCommittee;
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

        Call<List<Ducsu>> call = api.getDucsu();

        call.enqueue(new Callback<List<Ducsu>>() {
            @Override
            public void onResponse(Call<List<Ducsu>> call, Response<List<Ducsu>> response) {
                final List<Ducsu> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column3_header_layout,listView,false);
                ConstraintLayout innerConstraint = (ConstraintLayout) headerView.findViewById(R.id.innerConstraint);
                innerConstraint.setBackgroundColor(Color.parseColor("#aa00ff"));

                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Name");
                column3header1.setBackgroundColor(Color.parseColor("#aa00ff"));
                Guideline guideline1 = (Guideline) headerView.findViewById(R.id.guideline1);
                guideline1.setGuidelinePercent((float)0.32);

                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Rank");
                column3header2.setBackgroundColor(Color.parseColor("#aa00ff"));
                Guideline guideline2 = (Guideline) headerView.findViewById(R.id.guideline2);
                guideline2.setGuidelinePercent((float)0.68);

                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Department");
                column3header3.setBackgroundColor(Color.parseColor("#aa00ff"));
                Guideline guideline3 = (Guideline) headerView.findViewById(R.id.guideline3);
                guideline3.setGuidelinePercent((float)1.00);

                listView.addHeaderView(headerView);
/*
                ViewGroup rowView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column3_row_layout,listView,false);
                Guideline guidelineRow1 = (Guideline) rowView.findViewById(R.id.guideline1);
                guidelineRow1.setGuidelinePercent((float)0.40);
                Guideline guidelineRow2 = (Guideline) rowView.findViewById(R.id.guideline2);
                guidelineRow2.setGuidelinePercent((float)0.68);
                Guideline guidelineRow3 = (Guideline) rowView.findViewById(R.id.guideline3);
                guidelineRow3.setGuidelinePercent((float)1.00);
*/
                DucsuTableListAdapter adapter =
                        new DucsuTableListAdapter(DucsuActivity.this ,
                                R.layout.column3_row_layout_ducsu, fullCommittee );


                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Ducsu>> call, Throwable t) {
               // Toast.makeText(ImplementationCommitteActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
