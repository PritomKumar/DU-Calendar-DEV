package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
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

public class CalendarSpecificEventListActivity extends AppCompatActivity {

    List <SpecificCalendarDay> fullCommittee;
    ListView listView;

    String departmentName = "";
    String academicYear = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committe);

        Intent intent = getIntent();
        departmentName = intent.getStringExtra("departmentName" );
        academicYear = intent.getStringExtra("academicYear" );

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.tableList);

        Call<List<SpecificCalendarDay>> call = api.getSpecificEventDays(departmentName,academicYear);
        
        call.enqueue(new Callback<List<SpecificCalendarDay>>() {
            @Override
            public void onResponse(Call<List<SpecificCalendarDay>> call, Response<List<SpecificCalendarDay>> response) {
                final List<SpecificCalendarDay> fullCommittee = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.calendar_event_header_layout,listView,false);
                TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
                column3header1.setText("Date");
                TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
                column3header2.setText("Event Name");
                TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
                column3header3.setText("Description");

                listView.addHeaderView(headerView);

                CalendarSpecificEventTableListAdapter adapter = new CalendarSpecificEventTableListAdapter(CalendarSpecificEventListActivity.this ,
                        R.layout.calendar_event_row_layout, fullCommittee );


                listView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<SpecificCalendarDay>> call, Throwable t) {
               // Toast.makeText(ImplementationCommitteActivity.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
