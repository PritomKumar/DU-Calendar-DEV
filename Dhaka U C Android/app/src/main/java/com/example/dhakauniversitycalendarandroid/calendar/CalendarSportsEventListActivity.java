package com.example.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;

import java.util.ArrayList;

public class CalendarSportsEventListActivity extends AppCompatActivity {

    ArrayList <EventDay> fullCommittee;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committe);

        listView = (ListView) findViewById(R.id.tableList);

        fullCommittee = new ArrayList<EventDay>();

        Intent intent = getIntent();
        fullCommittee = (ArrayList<EventDay>) intent.getSerializableExtra("eventTableList" );

        //Log.d("dead" ,"Calendar is " + fullCommittee.get(0).getName());

        ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.calendar_sports_event_header_layout,listView,false);
        TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
        column3header1.setText("Date");
        TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
        column3header2.setText("Event Name");

        listView.addHeaderView(headerView);

        CalendarSportsEventTableListAdapter adapter = new CalendarSportsEventTableListAdapter(CalendarSportsEventListActivity.this ,
                R.layout.calendar_sports_event_row_layout, fullCommittee );


        listView.setAdapter(adapter);

    }
}
