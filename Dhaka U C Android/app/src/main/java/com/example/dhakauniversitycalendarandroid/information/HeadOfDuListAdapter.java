package com.example.dhakauniversitycalendarandroid.information;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

public class HeadOfDuListAdapter extends ArrayAdapter<HeadOfDU> {

    Context context;
    int resource ;
    List <HeadOfDU> duHeadList;

    public HeadOfDuListAdapter(Context context , int resource , List<HeadOfDU> duHeadList){
        super(context , resource , duHeadList);

        this.context = context;
        this.resource = resource;
        this.duHeadList = duHeadList;
    }

    private class MyviewHolder{

        TextView headOfDUName;
        TextView headOfDURank;
        TextView qualification;
        ImageView headOfDUImg;

        public MyviewHolder(View v) {
            this.headOfDUName = (TextView) v.findViewById(R.id.name);
            this.headOfDUImg = (ImageView) v.findViewById(R.id.image);
            this.headOfDURank = (TextView) v.findViewById(R.id.rank);
            this.qualification = (TextView) v.findViewById(R.id.educationalQualification);
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        MyviewHolder holder = null;

        if(view == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(resource, null);
            holder = new MyviewHolder(view);
            view.setTag(holder);
        }

        else {
            holder = (MyviewHolder) view.getTag();
        }


        HeadOfDU headOfDU = duHeadList.get(position);

        holder.headOfDUName.setText(headOfDU.getName());

       // Picasso.get().load(headOfDU.getImageUrl()).into(headOfDUImageView);
        Glide.with(context).load(headOfDU.getImage())
                .placeholder(R.drawable.dulogo).into(holder.headOfDUImg);

        holder.qualification.setText(headOfDU.getQualification());

        holder.headOfDURank.setText(headOfDU.getRank());

        //return super.getView(position, convertView, parent);
        return  view;
    }

}
