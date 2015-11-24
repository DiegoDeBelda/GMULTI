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
//CAMBIO DE COLORES CON RADIOBUTTON
public class PANTALLA1 extends AppCompatActivity {

    RadioButton radioRojo = (RadioButton)findViewById(R.id.radioButtonrojo);
    RadioButton radioAzul = (RadioButton)findViewById(R.id.radioButtonblue);
    RadioButton radioAmarillo = (RadioButton)findViewById(R.id.radioButtonyellow);

    Button Aceptar = (Button)findViewById(R.id.buttonConfirmar);
    Button Cancelar = (Button)findViewById(R.id.buttonCancelar);

    TextView miLbl = (TextView)findViewById(R.id.textView);

    Aceptar.setOnClickListener( new View.OnClickListener(){
        public void onClick(View v){
            if(radioRojo.isChecked()==true){
                miLbl.setBackgroundColor(Color.RED);
            }
            else if(radioAzul.isChecked()==true){
                miLbl.setBackgroundColor(Color.BLUE);
            }
            else if(radioAmarillo.isChecked()==true){
                miLbl.setBackgroundColor(Color.YELLOW);
            }
            else{
                miLbl.setBackgroundColor(Color.WHITE);
            }
        }

    });
    Cancelar.setOnClickListener(new View.OnClickListener(){
        miLbl.setBackgroundColor(Color.BLACK);
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
    }


}
