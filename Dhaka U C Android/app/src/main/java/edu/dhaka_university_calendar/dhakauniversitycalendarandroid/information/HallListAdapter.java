package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.information;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;

import java.util.List;

public class HallListAdapter extends ArrayAdapter<Hall> {

    Context context;
    int resource ;
    List <Hall> hallList;

    public HallListAdapter(Context context , int resource , List<Hall> hallList){
        super(context , resource , hallList);

        this.context = context;
        this.resource = resource;
        this.hallList = hallList;
    }

    private class MyviewHolder{

        TextView hallName;
        TextView faculty;
        ImageView hallImg;

        public MyviewHolder(View v) {
            this.hallName = (TextView) v.findViewById(R.id.name);
            this.hallImg = (ImageView) v.findViewById(R.id.image);
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
            Log.d("VIVZ" , "Creating a new row");
        }

        else {
            holder = (MyviewHolder) view.getTag();
            Log.d("VIVZ" , "Reclycing old row");
        }


        Hall hall = hallList.get(position);

        holder.hallName.setText(hall.getName());

       // Picasso.get().load(hall.getImageUrl()).into(hallImageView);
        Glide.with(context).load(hall.getImage())
                .placeholder(R.drawable.dulogo).into(holder.hallImg);

        //return super.getView(position, convertView, parent);
        return  view;
    }
}
