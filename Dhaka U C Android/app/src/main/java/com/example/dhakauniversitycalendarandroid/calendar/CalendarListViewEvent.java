package com.example.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.R;

import java.util.ArrayList;
import java.util.List;

public class CalendarListViewEvent extends AppCompatActivity {

    private ListView eventlist;
    List <EventDay> eventDayList = new ArrayList<EventDay>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_list_view);

        List <String> eventlistDescription = new ArrayList<String>();

        eventlist = (ListView) findViewById(R.id.eventList);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra("eventname");
        String description = intent.getStringExtra("eventdescription");
        eventDayList = (List<EventDay>) intent.getSerializableExtra("eventList");
        eventlistDescription.add(description);



        // EventDay event  = new EventDay("1" , eventName , description , "000");
      //  eventDayList.add(event);

        CalendarEventListAdapter  eventListAdapter = new CalendarEventListAdapter(CalendarListViewEvent.this ,
                R.layout.event_list_item2 ,eventDayList );
        eventlist.setAdapter(eventListAdapter);
/*
        ArrayAdapter <String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, eventlistDescription);

        eventlist.setAdapter(arrayAdapter);
  */
    }
}
