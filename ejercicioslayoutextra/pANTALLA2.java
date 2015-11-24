package com.example.khadeon.ejercicioslayoutextra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
//CAMBIO DE COLORES CON BOTONES
public class PANTALLA2 extends AppCompatActivity {



    Button ROJO = (Button)findViewById(R.id.buttonRojo);
    Button AZUL = (Button)findViewById(R.id.buttonAzul);
    Button AMARILLO = (Button)findViewById(R.id.buttonAmarillo);
    Button Borrar = (Button)findViewById(R.id.buttonBorrar);

    TextView myLbl = (TextView)findViewById(R.id.myLbl);


    ROJO.setOnClickListener( new View.OnClickListener(){
        public void onClick(View v){
            myLbl.setBackgroundColor(Color.RED);
        }

    });
    AZUL.setOnClickListener( new View.OnClickListener(){
        public void onClick(View v){
            myLbl.setBackgroundColor(Color.BLUE);
        }

    });
    AMARILLO.setOnClickListener( new View.OnClickListener(){
        public void onClick(View v){
            myLbl.setBackgroundColor(Color.YELLOW);
        }

    });
    Borrar.setOnClickListener(new View.OnClickListener(){
        miLbl.setBackgroundColor(Color.BLACK);
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
    }


}
