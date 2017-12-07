package com.garcesito.mapsexample;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity{

    GoogleMap mMap;
    MapView mapView;
    EditText eLatitud,eLongitud,eTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eLatitud= (EditText) findViewById(R.id.eLatitud);
        eLongitud= (EditText) findViewById(R.id.eLongitud);
        eTitulo= (EditText) findViewById(R.id.eTitulo);


    }



    public void agregar(View view) {
        String latitud = eLatitud.getText().toString();
        String longitud = eLongitud.getText().toString();
        String titulo = eTitulo.getText().toString();
        if(latitud.equals("")||longitud.equals("")||titulo.equals("")) {
            Toast.makeText(getApplicationContext(), "ingrese todos los datos", Toast.LENGTH_SHORT).show();
        }
        else {

            Intent intent = new Intent(MainActivity.this, MapsActivity.class);
            intent.putExtra("TITULO", titulo);
            intent.putExtra("LONGITUD", longitud);
            intent.putExtra("LATITUD", latitud);
            startActivity(intent);
        }

    }
}
