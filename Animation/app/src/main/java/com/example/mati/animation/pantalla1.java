package com.example.mati.animation;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ImageView;

public class pantalla1 extends Activity {
    AnimationDrawable animacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        animacion = (AnimationDrawable) getResources().getDrawable(R.anim.animacion);
        ImageView imagen = new ImageView(this);
        imagen.setBackgroundColor(Color.WHITE);
        imagen.setImageDrawable(animacion);
        setContentView(imagen);

    }
    public boolean onTouchEvent (MotionEvent evento){
        if (evento.getAction() == MotionEvent.ACTION_DOWN){
            animacion.start();
            return true;
        }
        return super.onTouchEvent(evento);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pantalla1, menu);
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
