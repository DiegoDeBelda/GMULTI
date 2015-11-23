package com.example.mati.menuspruebas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Toast;

public class pantalla1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
       getMenuInflater().inflate(R.menu.menu_pantalla1, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                Toast.makeText(this, "Opcion 1 pulsada!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc2:
                Toast.makeText(this, "Opcion 2 pulsada!", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.MnuOpc3:
                Toast.makeText(this, "Opcion 3 pulsada!", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

