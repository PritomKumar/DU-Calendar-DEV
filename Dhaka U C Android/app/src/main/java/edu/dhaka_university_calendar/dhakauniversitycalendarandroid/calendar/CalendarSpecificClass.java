package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.calendar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.Api;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.decorators.EventDecorator;
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

public class CalendarSpecificClass extends AppCompatActivity {

    MaterialCalendarView myCalendar ;
    List <CalendarDay> calendarDayList = new ArrayList<CalendarDay>();
    List <String> eventDescription = new ArrayList<String>();
    List <String> eventName = new ArrayList<String>();

    Retrofit retrofit;
    Api api;
    Call<List<SpecificCalendarDay>> call;
    boolean exist = false;

    String departmentName = "lalala";
    String academicYear = "momomo";


   // List<SpecificCalendarDay> events = new ArrayList<SpecificCalendarDay>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Intent intent = getIntent();
        departmentName = intent.getStringExtra("departmentName" );
        academicYear = intent.getStringExtra("academicYear" );

        //departmentName = "iit";
        myCalendar = (MaterialCalendarView) findViewById(R.id.calendarView);

        FloatingTextButton textlist = (FloatingTextButton) findViewById(R.id.listEvent);

        textlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarSpecificClass.this, CalendarSpecificEventListActivity.class);
                intent.putExtra("departmentName" , departmentName);
                intent.putExtra("academicYear" , academicYear);
                startActivity(intent);
            }
        });

        retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        api = retrofit.create(Api.class);
       // Toast.makeText(CalendarSpecificClass.this , departmentName , Toast.LENGTH_SHORT).show();
        //Log.d("department3" , departmentName);

       // getApiCall();

        if(departmentName==null){
            Toast.makeText(CalendarSpecificClass.this , "Please Select a Department/Institute" ,
                    Toast.LENGTH_SHORT).show();
            Intent intent2 = new Intent();
            startActivity(intent2);
        }
        else {
            exist= true;
        }
        departmentName = departmentName.trim();
        academicYear = academicYear.trim();
        Log.d("department3" , departmentName);


        call = api.getSpecificEventDays(departmentName,academicYear);

        if(exist == true) {

            call.enqueue(new Callback<List<SpecificCalendarDay>>() {
                @Override
                public void onResponse(Call<List<SpecificCalendarDay>> call,
                                       Response<List<SpecificCalendarDay>> response) {

                    final List<SpecificCalendarDay> events = response.body();

                    // Toast.makeText(CalendarClass.this, events.get(0).getName() , Toast.LENGTH_SHORT).show();
                    for (SpecificCalendarDay d : events) {
                        String temp = d.getDate();
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
                        addEvent(LocalDate.of(year, month, day), temp2, temp3);

                        Log.d("Pass", d.getId());
                        Log.d("Pass", d.getName());
                        Log.d("Pass", d.getDescription());
                        Log.d("Pass", d.getDate());
                        Log.d("Department Name", d.getDeptName());
                        Log.d("Academic year", d.getAcademicYear());

                        // Toast.makeText(CalendarClass.this, d.getName() , Toast.LENGTH_SHORT).show();
                    }

                    final EventDecorator eventDecorator = new EventDecorator(Color.BLUE, calendarDayList);
                    myCalendar.addDecorator(eventDecorator);

                }

                @Override
                public void onFailure(Call<List<SpecificCalendarDay>> call, Throwable t) {
                    // Toast.makeText(CalendarSpecificClass.this, t.getMessage() , Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            Toast.makeText(CalendarSpecificClass.this , "Sorry, department is not added yet" ,
                    Toast.LENGTH_SHORT).show();
        }
/*
        addEvent(LocalDate.of(2019,2,23) , "Hellow");
        addEvent(LocalDate.of(2019,2,26) , "Important Day");

*/
        myCalendar.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget,
                                       @NonNull CalendarDay date, boolean selected) {

                String s = myCalendar.getSelectedDate().toString();
                List<EventDay> speficEvents = new ArrayList<EventDay>();

                for(int i=0 ;i< eventDescription.size() ; i++ ) {

                    String temp = "CalendarDay{" + calendarDayList.get(i).getYear() +"-"+
                            calendarDayList.get(i).getMonth() +"-"+ calendarDayList.get(i).getDay() + "}";
                    if (s.equals(temp)) {
                        EventDay eventDay = new EventDay( "1" ,
                                eventName.get(i) , eventDescription.get(i),s  );
                        speficEvents.add(eventDay);
                    }

                }

                if(!speficEvents.isEmpty()) {
                    Intent intent = new Intent(CalendarSpecificClass.this, CalendarListViewEvent.class);
                    intent.putExtra("eventname", eventName.get(0));
                    intent.putExtra("eventdescription", eventDescription.get(0));
                    intent.putExtra("eventList", (ArrayList<EventDay>) speficEvents);
                    startActivity(intent);
                    //Toast.makeText(getApplicationContext(), eventDescription.get(i).toString(), Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CalendarSpecificClass.this, "No event today" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        Log.d("department5" , departmentName);

    }

    public void addEvent(LocalDate localDate , String eventN , String eventDes ){

        CalendarDay day = CalendarDay.from(localDate);
        calendarDayList.add(day);
        eventDescription.add(eventDes);
        eventName.add(eventN);

    }
}
