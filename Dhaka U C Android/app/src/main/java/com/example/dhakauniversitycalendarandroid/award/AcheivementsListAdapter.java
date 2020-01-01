package com.example.dhakauniversitycalendarandroid.award;

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
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

public class AcheivementsListAdapter extends ArrayAdapter<Acheivements> {

    Context context;
    int resource ;
    List <Acheivements> acheivementList;

    public AcheivementsListAdapter(Context context , int resource , List<Acheivements> acheivementList){
        super(context , resource , acheivementList);

        this.context = context;
        this.resource = resource;
        this.acheivementList = acheivementList;
    }

    private class MyviewHolder{

        TextView acheivementName;
        ImageView acheivementImg;

        public MyviewHolder(View v) {
            this.acheivementName = (TextView) v.findViewById(R.id.name);
            this.acheivementImg = (ImageView) v.findViewById(R.id.image);
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


        Acheivements acheivement = acheivementList.get(position);

        holder.acheivementName.setText(acheivement.getName());

       // Picasso.get().load(acheivement.getImageUrl()).into(acheivementImageView);
        Glide.with(context).load(acheivement.getImageUrl())
                .placeholder(R.drawable.dulogo).into(holder.acheivementImg);

        //return super.getView(position, convertView, parent);
        return  view;
    }
}
