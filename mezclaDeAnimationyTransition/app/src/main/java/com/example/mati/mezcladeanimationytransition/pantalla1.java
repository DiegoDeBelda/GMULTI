package com.example.mati.mezcladeanimationytransition;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);

        //transicion
        ImageView imagen = (ImageView) findViewById(R.id.imageView);
        ImageView imagen2 = (ImageView) findViewById(R.id.imageView2);
        setContentView(imagen);
        TransitionDrawable transacion = (TransitionDrawable)
                getResources().getDrawable(R.drawable.transicion);
        imagen.setImageDrawable(transacion);
        transacion.startTransition(3000);



        //animation
        AnimationDrawable animacion = (AnimationDrawable) getResources().getDrawable(R.anim.animacion);

        imagen2.setBackgroundColor(Color.WHITE);
        imagen2.setImageDrawable(animacion);
        setContentView(imagen);
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
