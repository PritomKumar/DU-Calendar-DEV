package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.committee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

public class ProvostOfHallTableListAdapter extends ArrayAdapter<ProvostOfHall> {

    int vg;
    List<ProvostOfHall> fullCommittee;
    Context context;

    public ProvostOfHallTableListAdapter(Context context , int vg , List <ProvostOfHall> fullCommittee){
        super(context , vg , fullCommittee);
        this.context = context;
        this.vg = vg;
        this.fullCommittee= fullCommittee;
    }

    static class ViewHolder{
        public TextView txtname;
        public TextView txtrank;

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

        holder.txtname.setText(fullCommittee.get(position).getHallName());
        holder.txtrank.setText(fullCommittee.get(position).getProvostName());

        return rowView;
    }

}
