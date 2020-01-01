package com.example.dhakauniversitycalendarandroid.more;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AffiliatedInstitutesActivity extends AppCompatActivity {

    List <AffiliatedInstitutes> fullCommittee;
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

        Call<List<AffiliatedInstitutes>> call = api.getAffiliatedInstitutes();

        call.enqueue(new Callback<List<AffiliatedInstitutes>>() {
            @Override
            public void onResponse(Call<List<AffiliatedInstitutes>> call, Response<List<AffiliatedInstitutes>> response) {
                final List<AffiliatedInstitutes> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.column3_header_layout,listView,false);
                ConstraintLayout innerConstraint = (ConstraintLayout) headerView.findViewById(R.id.innerConstraint);
                innerConstraint.setBackgroundColor(Color.parseColor("#aa00ff"));

                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Name");
                column3header1.setBackgroundColor(Color.parseColor("#aa00ff"));
                Guideline guideline1 = (Guideline) headerView.findViewById(R.id.guideline1);
                guideline1.setGuidelinePercent((float)0.40);

                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Institute");
                column3header2.setBackgroundColor(Color.parseColor("#aa00ff"));
                Guideline guideline2 = (Guideline) headerView.findViewById(R.id.guideline2);
                guideline2.setGuidelinePercent((float)0.68);

                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Governance");
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
                AffiliatedInstitutesTableListAdapter adapter =
                        new AffiliatedInstitutesTableListAdapter(AffiliatedInstitutesActivity.this ,
                                R.layout.column3_row_layout_affiliated_institutes, fullCommittee );


                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<AffiliatedInstitutes>> call, Throwable t) {
               // Toast.makeText(ImplementationCommitteActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
