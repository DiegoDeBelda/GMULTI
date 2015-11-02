package com.example.mati.listasimple;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyListaSimple extends AppCompatActivity {

    final static String semana[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    ListView lview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lista_simple);


        String mensaje;
        lview = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> miAdaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, semana);
        lview.setAdapter(miAdaptador);
        //definimos el metodo de foma anonima

        lview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + semana[position];
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
                showToast(mensaje);
            }
        });


    }

    public void showToast(String texto){
        Toast.makeText(getApplicationContext(),texto,Toast.LENGTH_LONG).show();

    }



}
