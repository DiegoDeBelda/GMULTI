package com.example.mati.ejemplodibujos2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class Pantalla1 extends Activity {

    private BitmapDrawable miImagen;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();
            miImagen = (BitmapDrawable) res.getDrawable(R.drawable.images);

        }
        @Override
        protected void onDraw(Canvas canvas) {

            //para poder sacar el ancho y alto de la pantalla, y por tanto el centro
            //usaremos getWidth y getHigh, lo divideremos entre dos.

            int x = canvas.getWidth()/2;
            int y = canvas.getHeight()/2;



            miImagen.setBounds(new Rect(x-100, y-100, x+100, y+100));


            //En este segunda forma de dibujar a la imagen le decimos donde debe ser dibujada
            Paint miPincel= new Paint();
            miPincel.setColor(Color.BLUE);
            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setStrokeWidth(5);
            canvas.drawCircle(x, y, 300, miPincel);

            miImagen.draw(canvas);

        }
    }

}