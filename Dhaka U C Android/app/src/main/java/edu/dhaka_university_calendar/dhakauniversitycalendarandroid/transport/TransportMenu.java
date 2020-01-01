package edu.dhaka_university_calendar.dhakauniversitycalendarandroid.transport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import edu.dhaka_university_calendar.dhakauniversitycalendarandroid.R;
import com.google.android.material.button.MaterialButton;

public class TransportMenu extends AppCompatActivity {

    private MaterialButton chytali;
    private MaterialButton torongo;
    private MaterialButton baishakhi;
    private MaterialButton khonika;
    private MaterialButton hemonto;
    private MaterialButton boshoto;
    private MaterialButton anando;
    private MaterialButton ullash;
    private MaterialButton srabon;
    private MaterialButton falguni;
    private MaterialButton ishakha;
    private MaterialButton kinchit;
    private MaterialButton moitree;
    private MaterialButton chittagongRoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_menu);

        chytali = (MaterialButton) findViewById(R.id.buttonChytali);

        chytali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportChytali.class);
                startActivity(intent);
            }
        });

        torongo = (MaterialButton) findViewById(R.id.buttonTorongo);

        torongo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportTorongo.class);
                startActivity(intent);
            }
        });

        khonika = (MaterialButton) findViewById(R.id.buttonKhonika);

        khonika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportKhonika.class);
                startActivity(intent);
            }
        });

        baishakhi = (MaterialButton) findViewById(R.id.buttonBaishakhi);

        baishakhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportBaishakhi.class);
                startActivity(intent);
            }
        });

        hemonto = (MaterialButton) findViewById(R.id.buttonHemonto);
        hemonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportHemonto.class);
                startActivity(intent);
            }
        });

        anando = (MaterialButton) findViewById(R.id.buttonAnondo);
        anando.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportAnando.class);
                startActivity(intent);
            }
        });

        boshoto = (MaterialButton) findViewById(R.id.buttonBoshonto);
        boshoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportBoshonto.class);
                startActivity(intent);
            }
        });

        srabon = (MaterialButton) findViewById(R.id.buttonSrabon);
        srabon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportSrabon.class);
                startActivity(intent);
            }
        });

        falguni = (MaterialButton) findViewById(R.id.buttonFalguni);
        falguni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportFalguni.class);
                startActivity(intent);
            }
        });

        ishakha = (MaterialButton) findViewById(R.id.buttonIshakha);
        ishakha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportIshakha.class);
                startActivity(intent);
            }
        });

        kinchit = (MaterialButton) findViewById(R.id.buttonKinchit);
        kinchit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportKinchit.class);
                startActivity(intent);
            }
        });

        moitree = (MaterialButton) findViewById(R.id.buttonMoitree);
        moitree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportMoitree.class);
                startActivity(intent);
            }
        });

        chittagongRoad = (MaterialButton) findViewById(R.id.buttonChittagongRoad);
        chittagongRoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportChittagongRoad.class);
                startActivity(intent);
            }
        });

        ullash = (MaterialButton) findViewById(R.id.buttonUllash);
        ullash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TransportMenu.this , TransportUllash.class);
                startActivity(intent);
            }
        });



    }
}
