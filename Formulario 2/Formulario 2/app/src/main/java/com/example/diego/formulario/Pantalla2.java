package com.example.diego.formulario;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Pantalla2 extends AppCompatActivity {
    //estas variables son usadas en el onclick, por lo que deben ser global.
    Context context;
    Dest destino;
    SQLiteHelper cliBDh;
    SQLiteDatabase db;
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
        double precioFinal = precio + precioExtra;
        int Peso = bundle.getInt("Peso");
        double suma = bundle.getDouble("PRECIO TOTAL (Precio + precio extra por tipo de envio");
        String urgencia = bundle.getString("urgencia del envio");


        int img = bundle.getInt("IMAGEN");

        String envio = bundle.getString("Envio");




        viewZona.setText("Zona: "+Zona);
        viewContinente.setText("Continente: "+Continente);
        viewPrecio.setText(String.valueOf("Precio: "+precio));
        viewPrecioExtra.setText(String.valueOf("Precio extra: " + precioExtra));
        viewPrecioTotal.setText(String.valueOf("Precio TOTAL: " + precioFinal));
        viewPeso.setText(String.valueOf("Peso del paquete: " + Peso));
        viewImagen.setImageResource(img);

        Button cargar = (Button)findViewById(R.id.Registrar);
        destino = new Dest(Zona, Continente, img, ""+precio);
        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               cliBDh=new SQLiteHelper(Pantalla2.this, "DBClientes", null, 1);
               db=cliBDh.getWritableDatabase();
               cliBDh.insertarBD(db,Pantalla2.this,destino);



            }
        });
        Button ver = (Button)findViewById(R.id.Visualizar);
        ver.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), pantalla3.class);
                startActivity(intent);
            }
        });


       // Reloj.setVisibility(ImageView.VISIBLE);

    }
}
