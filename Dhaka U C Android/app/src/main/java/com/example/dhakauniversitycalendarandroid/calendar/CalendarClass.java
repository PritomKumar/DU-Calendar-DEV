package com.example.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;
import com.example.dhakauniversitycalendarandroid.decorators.EventDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.dimorinny.floatingtextbutton.FloatingTextButton;

public class CalendarClass extends AppCompatActivity {

    MaterialCalendarView myCalendar ;
    List <CalendarDay> calendarDayList = new ArrayList<CalendarDay>();
    List <String> eventDescription = new ArrayList<String>();
    List <String> eventName = new ArrayList<String>();
    ArrayList<EventDay> eventTableList = new ArrayList<EventDay>();
   // List<EventDay> events = new ArrayList<EventDay>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        myCalendar = (MaterialCalendarView) findViewById(R.id.calendarView);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<List<EventDay>> call = api.getEventDays();


        call.enqueue(new Callback<List<EventDay>>() {
            @Override
            public void onResponse(Call<List<EventDay>> call, Response<List<EventDay>> response) {

                final List<EventDay> events  = response.body();
               // Toast.makeText(CalendarClass.this, events.get(0).getName() , Toast.LENGTH_SHORT).show();
                for(EventDay d : events){
                    String temp = d.getdate();
                    //String temp = "29/03/2019";
                    //String temp =  "13-03-20";
                    String fullDate[]  = new String[4];
                    if(temp.contains("/")) {
                        fullDate = temp.split("/");
                    }
                    else if(temp.contains("-")) {
                        fullDate = temp.split("-");
                    }
                    int day = Integer.parseInt(fullDate[0]);
                    int month = Integer.parseInt(fullDate[1]);
                    String yearString = "";
                    if(fullDate[2].length()==2){
                        yearString = "20" + fullDate[2];
                        fullDate[2] = yearString;
                    }
                    int year = Integer.parseInt(fullDate[2]);

                    final String temp2 = d.getName();
                    final String temp3 = d.getDescription();
                    String temp4 = d.getId();
                    EventDay eventDayTemp = new EventDay(temp4,temp2 , temp3 , temp);
                    eventTableList.add(eventDayTemp);
                    addEvent(LocalDate.of(year, month , day) ,temp2 , temp3);
/*
                    Log.d("id" , d.getId() );
                    Log.d("eventname" , d.getName());
                    Log.d("description" , d.getDescription() );
                    Log.d("date" , d.getdate());

                    */
                   // Toast.makeText(CalendarClass.this, d.getName() , Toast.LENGTH_SHORT).show();
                }

                final EventDecorator eventDecorator = new EventDecorator(Color.RED,calendarDayList);
                myCalendar.addDecorator(eventDecorator);

            }

            @Override
            public void onFailure(Call<List<EventDay>> call, Throwable t) {
               // Toast.makeText(CalendarClass.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });

        FloatingTextButton textlist = (FloatingTextButton) findViewById(R.id.listEvent);

        textlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarClass.this, CalendarEventListActivity.class);
                intent.putExtra("eventTableList" , eventTableList);
                startActivity(intent);
            }
        });

/*
        addEvent(LocalDate.of(2019,2,23) , "Hellow");
        addEvent(LocalDate.of(2019,2,26) , "Important Day");

*/
        myCalendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {

                String s = myCalendar.getSelectedDate().toString();
                List<EventDay> events = new ArrayList<EventDay>();

                for(int i=0 ;i< eventDescription.size() ; i++ ) {

                    String temp = "CalendarDay{" + calendarDayList.get(i).getYear() +"-"+ calendarDayList.get(i).getMonth() +"-"+ calendarDayList.get(i).getDay() + "}";
                    if (s.equals(temp)) {
                        EventDay eventDay = new EventDay( "1" , eventName.get(i) , eventDescription.get(i),s );
                        events.add(eventDay);
                    }

                }

                if(!events.isEmpty()) {
                    Intent intent = new Intent(CalendarClass.this, CalendarListViewEvent.class);
                    intent.putExtra("eventname", eventName.get(0));
                    intent.putExtra("eventdescription", eventDescription.get(0));
                    intent.putExtra("eventList", (ArrayList<EventDay>) events);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), eventDescription.get(i).toString(), Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(CalendarClass.this, "No event today" , Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void addEvent(LocalDate localDate , String eventN , String eventDes ){

        CalendarDay day = CalendarDay.from(localDate);
        calendarDayList.add(day);
        eventDescription.add(eventDes);
        eventName.add(eventN);

    }
}
