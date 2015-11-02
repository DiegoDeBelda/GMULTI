package com.example.mati.listatitulares;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Titular[] misTitulares = {
            new Titular("Maria", "Pacual"),
            new Titular("Marie", "Pacual")

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);

        ListView lstOpciones = (ListView) findViewById(R.id.listView1);
        lstOpciones.setAdapter(adaptador);

        String mensaje;




        //definimos el metodo de foma anonima

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "";
                mensaje = "Item clicked => " + misTitulares[position];
                //Toast.makeText(getApplicationContext(), mensaje, Toast.LENGTH_LONG);
                showToast(mensaje);
            }
        });


    }





    public void showToast(String texto){
        Toast.makeText(getApplicationContext(), texto, Toast.LENGTH_LONG).show();
    }


    class AdaptadorTitulares extends ArrayAdapter {
        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.listitem_titular, misTitulares);
            this.context = context;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_titular, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.LblNombre);
            lblTitulo.setText(misTitulares[position].getNombre());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.LblApellido);
            lblSubtitulo.setText(misTitulares[position].getApellido());
            return (item);
        }
    }
}