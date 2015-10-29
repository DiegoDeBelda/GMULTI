package com.example.mati.radiobuttonprueba;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class pantalla1 extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);


        final TextView lblMensaje = (TextView) findViewById(R.id.LblSeleccion);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.gruporb);
        rg.clearCheck();
        final RadioButton rb1 = (RadioButton) findViewById(R.id.radio1);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.radio2);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
public void onCheckedChanged(RadioGroup group, int checkedId) {
        //lblMensaje.setText("Opcion seleccionada: " + checkedId);
            if(rb1.isChecked()){
                lblMensaje.setText("Opcion seleccionada: "+rb1.getText());

            }
            else{
                lblMensaje.setText("Opcion seleccionada: "+rb2.getText());

            }
        }
        });

}

}