package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

public class GradingSystemTableListAdapter extends ArrayAdapter<GradeSystem> {

    int vg;
    List<GradeSystem> fullCommittee;
    Context context;

    public GradingSystemTableListAdapter(Context context , int vg , List <GradeSystem> fullCommittee){
        super(context , vg , fullCommittee);
        this.context = context;
        this.vg = vg;
        this.fullCommittee= fullCommittee;
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

        holder.txtname.setText(fullCommittee.get(position).getMarks());
        holder.txtrank.setText(fullCommittee.get(position).getGrade());
        holder.txtmembership.setText(fullCommittee.get(position).getPoint());

        return rowView;
    }

}
