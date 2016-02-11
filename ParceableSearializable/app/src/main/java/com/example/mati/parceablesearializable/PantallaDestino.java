package com.example.mati.parceablesearializable;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by mati on 11/02/16.
 */
public class PantallaDestino extends AppCompatActivity{

    Bundle bundle;
    ClaseSerializable serial;
    ClaseParceable parc;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destino);

        bundle=  getIntent().getExtras();
        TextView textoid = (TextView)findViewById(R.id.texto1);
        TextView textoNombre = (TextView)findViewById(R.id.texto2);

        if(bundle.getParcelable("Parceable")==null) {
            serial = (ClaseSerializable) bundle.getSerializable("Serializable");

            textoid.setText(String.valueOf(serial.getId()));
            textoNombre.setText(serial.getNombre());
        }else {
//        Toast.makeText(PantallaDestino.this, "ahora vamos a recoger con parceable", Toast.LENGTH_SHORT).show();

            parc = (ClaseParceable) bundle.getParcelable("Parceable");

            textoid.setText(String.valueOf(parc.getId()));
            textoNombre.setText(parc.getNombre());
        }

    }

}
