package com.example.mati.diegobici;
import android.app.Activity;
import android.os.Bundle;

public class AcercaDe extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //Hacemos visible la interfaz/layout que se encuentra en acercade.xml
        setContentView(R.layout.acercade);
    }
}