package com.example.mati.holamundo2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by mati on 5/10/15.
 */
public class Pantalla2 extends Activity {
    public MediaPlayer miMusica= MediaPlayer.create(getApplicationContext(),R.raw.dragonmiedo);
    protected void showToast(CharSequence text){
        //conseguir saber donde estamos si pantalla 1 o pantalla 2 etc
        Context context = getApplicationContext();
        //marcar la duracion del mensaje
        int duration = Toast.LENGTH_SHORT;
        //creamos el widget con estos parametros y lo iniciamos
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

    }
    @Override
    protected void onResume(){
        miMusica.stop();
        super.onResume();
        Toast.makeText(this, "Pantalla 2 on resume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart(){
        miMusica.stop();
        super.onStart();
        Toast.makeText(this, "Pantalla 2 onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPause(){
        Toast.makeText(this, "Pantalla 2 on pause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "Pantalla 2 on stop", Toast.LENGTH_SHORT).show();
    }
    //@Override
    //protected void onRestart(){
     //   super.onRestart();
      //  Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    //}
    @Override
    protected void onDestroy(){
        Toast.makeText(this, "Pantalla 2 on destroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView otroSaludo= (TextView)findViewById(R.id.miMensaje);
        Bundle miBundleRecoger = getIntent().getExtras();
        otroSaludo.setText(miBundleRecoger.getString("TEXTO"));

        final ImageButton BtnImage = (ImageButton)findViewById(R.id.BtnImage);
       BtnImage.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                //intent = objeto cambio actividad
                Intent miIntent= new Intent(Pantalla2.this, Hola2.class);
                //empaquetar
                Bundle miBundle=new Bundle();
                String mensajePaso= "Te saludo " + otroSaludo.getText();
                miBundle.putString("TEXTO", mensajePaso);
                miIntent.putExtras(miBundle);
                startActivity(miIntent);
            }
        });
        showToast("Estoy en el evento 2 ");
    }
}