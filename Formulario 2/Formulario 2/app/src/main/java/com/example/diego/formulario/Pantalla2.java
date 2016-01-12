package com.example.diego.formulario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AnalogClock;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView viewZona = (TextView) findViewById(R.id.tzona);
        final TextView viewContinente = (TextView) findViewById(R.id.tcontinente);
        final TextView viewPrecio = (TextView) findViewById(R.id.tprecio);
        final TextView viewPrecioExtra = (TextView) findViewById(R.id.tprecioextra);
        final TextView viewPrecioTotal = (TextView) findViewById(R.id.tpreciototal);
        final TextView viewPeso = (TextView)findViewById(R.id.tpeso);
        final ImageView viewImagen = (ImageView) findViewById(R.id.timagen);
        //final AnalogClock Reloj = (AnalogClock)findViewById(R.id.reloj);
        //final TextView viewPreferencia = (TextView)findViewById(R.id.;


        Bundle bundle = getIntent().getExtras();

        String Zona = bundle.getString("Zona");
        String Continente = bundle.getString("Continente");
        double precio = bundle.getDouble("precio");
        double precioExtra = bundle.getDouble("PrecioExtra");
        int Peso = bundle.getInt("Peso");
        double suma = bundle.getDouble("PRECIO TOTAL (Precio + precio extra por tipo de envio");
        String urgencia = bundle.getString("urgencia del envio");


        int img = bundle.getInt("IMAGEN");

        String envio = bundle.getString("Envio");




        viewZona.setText(Zona);
        viewContinente.setText(Continente);
        viewPrecio.setText(String.valueOf(precio));
        viewPrecioExtra.setText(String.valueOf(precioExtra));
        viewPrecioTotal.setText(String.valueOf(precio+precioExtra));
        viewPeso.setText(String.valueOf(Peso));
        viewImagen.setImageResource(img);

       // Reloj.setVisibility(ImageView.VISIBLE);

    }
}
