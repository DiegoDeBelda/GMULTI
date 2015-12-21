package com.example.mati.diegobici;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SoloBici extends Activity {

    private Button bAcercaDe;
    private Button bJuego;
    private Button bPreferencias;
    private Button bSalir;

    private Button btnPreferencias;
    private Button btnObtenerPreferencias;

    //Boton y escuchador para la pantalla "Juego"

    //COMENTARIO DE LUCA Y PABLO: de nada.

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solo_bici);
        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarJuego();
            }
        });

        //Boton y escuchador para la pantalla "Acerca de"
        bAcercaDe = (Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarAcercaDe();
            }
        });

        //Boton y escuchador para la pantalla "Salir"
        bSalir = (Button) findViewById(R.id.Boton04);
        bSalir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                lanzarSalir();
            }
        });

        bPreferencias = (Button) findViewById(R.id.Boton02);
        bPreferencias.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                lanzarPreferencia();
            }
        });


        btnPreferencias.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                startActivity(new Intent(EjemploPreferencias.this,
                        Preferencia.class));
            }	});

        btnObtenerPreferencias.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SharedPreferences pref =
                        PreferenceManager.getDefaultSharedPreferences(
                                EjemploPreferencias.this);
                Log.i("", "Opción 1: " + pref.getBoolean("opcion1", false));
                Log.i("", "Opción 2: " + pref.getString("opcion2", ""));
                Log.i("", "Opción 3: " + pref.getString("opcion3", ""));
            } });

    }


    //Metodo que activa la pantalla Juego

    public void lanzarPreferencia(){
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }
    public void lanzarJuego(){
        Intent i = new Intent(this, Juego.class);
        startActivity(i);
    }

    //Metodo que activa la pantalla AcercaDe
    public void lanzarAcercaDe(){
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }


    //Metodo que activa la pantalla AcercaDe
    public void lanzarSalir(){
        finish();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_solo_bici, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
