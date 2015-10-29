package com.example.mati.holamundo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

import java.io.IOException;

public class Hola2 extends Activity {
    public static int COD_RESPUESTA=0;
    public MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.dragonmiedo);


    TextView elSaludo;


    protected void showToast(CharSequence text){
        //conseguir saber donde estamos si pantalla 1 o pantalla 2 etc
        Context context = getApplicationContext();
        //marcar la duracion del mensaje
        int duration = Toast.LENGTH_SHORT;
        //creamos el widget con estos parametros y lo iniciamos
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    protected void showAlert(CharSequence text){
        //con esto vemos en que actividad estamos gracias al this.
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        //mostramos el texto
        alert.setMessage(text);
        //¿?¿?
        alert.setPositiveButton(android.R.string.ok, null);

    }
    @Override
    protected void onResume(){
        super.onResume();
        try {
            if (miMusica.isPlaying()==false) {
                miMusica.prepare();
                miMusica.start();
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } ;



        Toast.makeText(this, "Pantalla 1 on resume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "Pantalla 1 on Start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPause(){
        miMusica.pause();
        Toast.makeText(this, "Pantalla 1 on pause", Toast.LENGTH_SHORT).show();
        super.onPause();

    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Pantalla 1 on stop", Toast.LENGTH_SHORT).show();
    }/*
    @Override
    protected void onRestart(){
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }*/
    @Override
    protected void onDestroy(){
        Toast.makeText(this, "Pantalla 1 on destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hola2);
        final EditText miTexto= (EditText)findViewById(R.id.miTxt);
        final Button miBoton= (Button)findViewById(R.id.miBtn);

        //definimos un reproductor de musica en segundo plano



        elSaludo= (TextView)findViewById(R.id.miLbl);

        //Borrar el texto inicial del EditText
        miTexto.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                miTexto.setText("");
            }
        });
        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //intent = objeto cambio actividad
                Intent miIntent = new Intent(Hola2.this, Pantalla2.class);
                //empaquetar
                Bundle miBundle = new Bundle();
                String mensajePaso = "Te saludo " + miTexto.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });
        showToast("Estoy en el evento 1 ");
    }
}
