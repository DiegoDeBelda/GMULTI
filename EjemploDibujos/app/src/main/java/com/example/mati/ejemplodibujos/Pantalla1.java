package com.example.mati.ejemplodibujos;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));
    }
    class MiDibujo extends View {
        public MiDibujo(Context c){

            super(c);
        }

        protected void onDraw(Canvas lienzo){


            Paint miPincel= new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setStrokeWidth(5);
            for (int i=1; i<400; i+=20) {
                lienzo.drawCircle(500, 500, 300-i, miPincel);
            }


            miPincel.setTextSize(50);
            lienzo.drawText("MI CIRCULO y LINEAS con Paleta de colores", 500, 1300, miPincel);

            //COGE LOS VALORES COMO FLOAT

            Paint[] paleta = new Paint[3] ;
            //definir pinceles
            for (int i=0; i<paleta.length; i++){
                paleta[i] = new Paint();
                paleta[i].setStyle(Paint.Style.STROKE);
                paleta[i].setStrokeWidth(5+i);
            }
            //definir colores
            paleta[0].setColor(Color.BLUE);
            paleta[1].setColor(Color.RED);
            paleta[2].setColor(Color.BLACK);

            for(int j=1; j<300; j+=20 ) {
                //primera forma de dibujar, al lienzo se le dice que dibujar
                lienzo.drawLine(1, j, 200, j, paleta[j%3]);

            }


        }
    }


}
