package com.example.mati.checkbox_prueba;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;



public class pantalla1 extends AppCompatActivity {


    //creacion de las variables
    CheckBox chkBoxleer;
    CheckBox chkBoxescribir;
    CheckBox chkBoxlamusica;

    Button aceptar;
    //resultado
    TextView txtHobby;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        initialUISetup();
    }
    public void showTextNotification(String msgToDisplay) {
        txtHobby.setText(msgToDisplay);
        //Toast.makeText(this, msgToDisplay, Toast.LENGTH_SHORT).show();

    }


    public void getHobbyClick(View v) {
        //con este metodo, añadiremos al resultado la cadena correspondiente al checkbox apretado
        String strMessage = "te gusta ";
        String strMessage2 = "no te gusta nada ? D:";
        String[] gustos = new String[3];


        if (chkBoxleer.isChecked()) {

            gustos[0]="leer";
            showTextNotification(strMessage+" "+gustos[0]+", a mi tambien :D");

        }
        if (chkBoxescribir.isChecked()) {

            gustos[1]="escribir";
            showTextNotification(strMessage+" "+gustos[1]+", a mi tambien :D");
        }
        if (chkBoxlamusica.isChecked()) {

            gustos[2]="la musica";
            showTextNotification(strMessage+" "+gustos[2]+", a mi tambien :D");
        }
        if (chkBoxleer.isChecked()==false && chkBoxescribir.isChecked()==false && chkBoxlamusica.isChecked()==false){
            showTextNotification(strMessage2);
        }

    }


    public void initialUISetup() {
        //asociacion a la interfaz
        chkBoxleer = (CheckBox) findViewById(R.id.chkBoxleer);
        chkBoxescribir = (CheckBox) findViewById(R.id.chkBoxescribir);
        chkBoxlamusica = (CheckBox) findViewById(R.id.chkBoxlamusica);
        aceptar = (Button) findViewById(R.id.aceptar);
        txtHobby = (TextView) findViewById(R.id.txtHobby);
        //escuchador de boton
        aceptar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                getHobbyClick(v);
            }
        });

        chkBoxleer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getHobbyClick(buttonView);
            }
        });
        chkBoxescribir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getHobbyClick(buttonView);
            }
        });
        chkBoxlamusica.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getHobbyClick(buttonView);
            }
        });
    }


}