package com.example.dhakauniversitycalendarandroid.transport;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dhakauniversitycalendarandroid.Api;
import com.example.dhakauniversitycalendarandroid.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransportTorongo extends AppCompatActivity {

    List <Transport> transportList;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(Api.baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        listView = (ListView) findViewById(R.id.tableList);

        //Call<List<Transport>> call = api.getTransportTorongo();
        Call<List<Transport>> call = api.getTransportRetrofit("Torongo");

        call.enqueue(new Callback<List<Transport>>() {
            @Override
            public void onResponse(Call<List<Transport>> call, Response<List<Transport>> response) {
                final List<Transport> transportList = response.body();

                ViewGroup headerView =  (ViewGroup) getLayoutInflater().inflate(R.layout.transport_header_layout,listView,false);
                listView.addHeaderView(headerView);
/*
//Pore Dekhbo
                ViewGroup footer =  (ViewGroup) getLayoutInflater().inflate(R.layout.bottom_navigation_bar,listView,false);
                listView.addFooterView(footer);
*/
                TransportTableListAdapter adapter = new TransportTableListAdapter(TransportTorongo.this ,
                        R.layout.transport_row_layout, transportList );
                listView.setAdapter(adapter);

                for(Transport d : transportList){
                    Log.d("id" , d.getId() );
                    Log.d("name" , d.getBusName() );
                    Log.d("route" , d.getRoute() );
                    Log.d("busType" , d.getBusType() );
                    Log.d("runType" , d.getRunType() );
                    Log.d("time" , d.getTime() );

                }

            }

            @Override
            public void onFailure(Call<List<Transport>> call, Throwable t) {
            //    Toast.makeText(TransportTorongo.this, t.getMessage() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}
