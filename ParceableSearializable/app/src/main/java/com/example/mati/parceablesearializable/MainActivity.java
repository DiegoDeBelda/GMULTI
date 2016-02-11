package com.example.mati.parceablesearializable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botonParceable = (Button)findViewById(R.id.botonParceable);
        Button botonSerializable = (Button)findViewById(R.id.botonSerializable);

        final ClaseSerializable serial = new ClaseSerializable(1, "nombre");
        final ClaseParceable parc = new ClaseParceable();

        parc.setId(2);
        parc.setNombre("nombre2");


        botonSerializable.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("Serializable", serial);
                Intent activitySerial = new Intent(MainActivity.this, PantallaDestino.class);

                activitySerial.putExtras(bundle);
                startActivity(activitySerial);
            }
        });

        botonParceable.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putParcelable("Parceable", parc);
                Intent activityParcel = new Intent(MainActivity.this, PantallaDestino.class);

                activityParcel.putExtras(bundle);
                startActivity(activityParcel);
            }
        });



    }
}
