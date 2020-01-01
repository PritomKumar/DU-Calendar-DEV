package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.award;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

public class DeansAwardWinnersTableListAdapter extends ArrayAdapter<DeansAwardWinners> {

    int vg;
    List<DeansAwardWinners> fullCommittee;
    Context context;

    public DeansAwardWinnersTableListAdapter(Context context , int vg , List <DeansAwardWinners> fullCommittee){
        super(context , vg , fullCommittee);
        this.context = context;
        this.vg = vg;
        this.fullCommittee= fullCommittee;
    }

    static class ViewHolder{
        public TextView txtname;
        public TextView txtrank;
        public TextView txtmembership;
        public TextView txtchairman;

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
            holder.txtchairman = (TextView) rowView.findViewById(R.id.txtchairmanname);


            rowView.setTag(holder);
        }

        ViewHolder holder =(ViewHolder) rowView.getTag();

        holder.txtname.setText(fullCommittee.get(position).getName());
        holder.txtrank.setText(fullCommittee.get(position).getDepartment());
        holder.txtmembership.setText(fullCommittee.get(position).getResult());
        holder.txtchairman.setText(fullCommittee.get(position).getYear());

        return rowView;
    }

}
