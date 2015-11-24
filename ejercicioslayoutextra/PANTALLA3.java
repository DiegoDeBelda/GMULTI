package com.example.khadeon.ejercicioslayoutextra;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

//PROIYECTO SUMA
public class PANTALLA3 extends AppCompatActivity {

    RadioButton suma = (RadioButton)findViewById(R.id.suma);
    RadioButton restar = (RadioButton)findViewById(R.id.resta);

    Button igual = (Button)findViewById(R.id.igual);

    EditText entrada1 = (EditText)findViewById(R.id.entrada1);
    EditText entrada2 = (EditText)findViewById(R.id.entrada2);

    TextView salida = (TextView)findViewById(R.id.salida);

    igual.setOnClickListener( new View.OnClickListener(){
        public void onClick(View v){
            if(suma.isChecked()==true){

                int valor1 = Integer.parseInt(entrada1.toString());
                int valor2 = Integer.parseInt(entrada2.toString());

                int valor3 = valor1+valor2;
                salida.setText(valor3);
            }
            else if(restar.isChecked()==true){
                int valor1 = Integer.parseInt(entrada1.toString());
                int valor2 = Integer.parseInt(entrada2.toString());

                int valor3 = valor1-valor2;
                salida.setText(valor3);
            }

            else{
                Toast.makeText(this, "No has seleccionado nada", Toast.LENGTH_SHORT);
            }
        }

    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
    }


}
