package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.ArrayList;

public class CalendarEventListActivity extends AppCompatActivity {

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

        ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.calendar_event_header_layout,listView,false);
        TextView column3header1 = (TextView) headerView.findViewById(R.id.column3header1);
        column3header1.setText("Date");
        TextView column3header2 = (TextView) headerView.findViewById(R.id.column3header2);
        column3header2.setText("Event Name");
        TextView column3header3 = (TextView) headerView.findViewById(R.id.column3header3);
        column3header3.setText("Description");

        listView.addHeaderView(headerView);

        CalendarEventTableListAdapter adapter = new CalendarEventTableListAdapter(CalendarEventListActivity.this ,
                R.layout.calendar_event_row_layout, fullCommittee );


        listView.setAdapter(adapter);

    }
}
