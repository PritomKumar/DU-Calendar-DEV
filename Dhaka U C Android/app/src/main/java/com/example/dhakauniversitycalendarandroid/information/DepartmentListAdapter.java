package com.example.dhakauniversitycalendarandroid.information;

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

public class DepartmentListAdapter extends ArrayAdapter<Department> {

    Context context;
    int resource ;
    List <Department> departmentList;

    public DepartmentListAdapter(Context context , int resource , List<Department> departmentList){
        super(context , resource , departmentList);

        this.context = context;
        this.resource = resource;
        this.departmentList = departmentList;
    }

    private class MyviewHolder{

        TextView departmentName;
        ImageView departmentImg;

        public MyviewHolder(View v) {
            this.departmentName = (TextView) v.findViewById(R.id.name);
            this.departmentImg = (ImageView) v.findViewById(R.id.image);;
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


        Department department = departmentList.get(position);

        holder.departmentName.setText(department.getName());

       // Picasso.get().load(department.getImageUrl()).into(departmentImageView);
        Glide.with(context).load(department.getImage())
                .placeholder(R.drawable.dulogo).into(holder.departmentImg);

        //return super.getView(position, convertView, parent);
        return  view;
    }
}
