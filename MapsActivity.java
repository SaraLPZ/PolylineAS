package com.example.polyline;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private EditText etLatitud,etLongitud;
    private Button btnInsertar;
    private PolylineOptions opcionesPolyline=new PolylineOptions().color(Color.BLUE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etLatitud=findViewById(R.id.etLatitud);
        etLongitud=findViewById(R.id.etLongitud);
        btnInsertar=findViewById(R.id.btnInsertar);
        btnInsertar.setEnabled(false);
        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Miro los campos, con sus valores creo un LatLng y ese LatLng se lo añado al Polylyne_opction
                double latitud=Double.parseDouble(etLatitud.getText().toString());
                double longitud=Double.parseDouble(etLongitud.getText().toString());
                LatLng punto=new LatLng(latitud,longitud);
                opcionesPolyline.add(punto);
                mMap.addPolyline(opcionesPolyline);
            }
        });

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        findViewById(R.id.cargaMapa).setVisibility(View.INVISIBLE);
        mMap = googleMap;
        btnInsertar.setEnabled(true);



        
    }
}