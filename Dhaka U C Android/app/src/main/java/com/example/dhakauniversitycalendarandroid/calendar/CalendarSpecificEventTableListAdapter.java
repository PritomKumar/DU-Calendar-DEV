package com.example.dhakauniversitycalendarandroid.calendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

public class CalendarSpecificEventTableListAdapter extends ArrayAdapter<SpecificCalendarDay> {

    int vg;
    List<SpecificCalendarDay> events;
    Context context;

    public CalendarSpecificEventTableListAdapter(Context context , int vg , List <SpecificCalendarDay> events){
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
            holder.txtmembership = (TextView) rowView.findViewById(R.id.txtmembership);

            rowView.setTag(holder);
        }

        ViewHolder holder =(ViewHolder) rowView.getTag();

        holder.txtname.setText(events.get(position).getDate());
        holder.txtrank.setText(events.get(position).getName());
        holder.txtmembership.setText(events.get(position).getDescription());

        return rowView;
    }

}
