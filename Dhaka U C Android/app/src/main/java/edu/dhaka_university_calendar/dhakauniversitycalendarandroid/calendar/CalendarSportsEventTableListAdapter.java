package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

public class CalendarSportsEventTableListAdapter extends ArrayAdapter<EventDay> {

    int vg;
    List<EventDay> events;
    Context context;

    public CalendarSportsEventTableListAdapter(Context context , int vg , List <EventDay> events){
        super(context , vg , events);
        this.context = context;
        this.vg = vg;
        this.events= events;
    }

    static class ViewHolder{
        public TextView txtname;
        public TextView txtrank;
        public TextView txtmembership;

    }

    public View getView(int position , View convertView , ViewGroup parent){
        View rowView = convertView;
        if(rowView ==null){
            LayoutInflater inflater =  (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(vg , parent , false);
            ViewHolder holder = new ViewHolder();
            holder.txtname = (TextView) rowView.findViewById(R.id.facultyname);
            holder.txtrank = (TextView) rowView.findViewById(R.id.deanName);

            rowView.setTag(holder);
        }

        ViewHolder holder =(ViewHolder) rowView.getTag();

        holder.txtname.setText(events.get(position).getdate());
        holder.txtrank.setText(events.get(position).getName());

        return rowView;
    }

}
