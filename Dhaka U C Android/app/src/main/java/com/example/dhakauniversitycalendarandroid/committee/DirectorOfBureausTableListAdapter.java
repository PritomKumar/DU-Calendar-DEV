package com.example.dhakauniversitycalendarandroid.committee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

public class DirectorOfBureausTableListAdapter extends ArrayAdapter<DirectorOfBureaus> {

    int vg;
    List<DirectorOfBureaus> fullCommittee;
    Context context;

    public DirectorOfBureausTableListAdapter(Context context , int vg , List <DirectorOfBureaus> fullCommittee){
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
        public TextView txtdirector;

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
            holder.txtdirector = (TextView) rowView.findViewById(R.id.txtdepartmentname);

            rowView.setTag(holder);
        }

        ViewHolder holder =(ViewHolder) rowView.getTag();

        holder.txtname.setText(fullCommittee.get(position).getCenterName());
        holder.txtrank.setText(fullCommittee.get(position).getConstitutionDate());
        holder.txtmembership.setText(fullCommittee.get(position).getCommitteeDate());
        holder.txtchairman.setText(fullCommittee.get(position).getChairmanName());
        holder.txtdirector.setText(fullCommittee.get(position).getDirectorName());

        return rowView;
    }

}
