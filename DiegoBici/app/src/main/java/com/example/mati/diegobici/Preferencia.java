package com.example.mati.diegobici;
import android.os.Bundle;
import android.preference.PreferenceActivity;
/**
 * Created by mati on 21/12/15.
 */
public class Preferencia {


    public class PantallaOpciones extends PreferenceActivity {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.layout.preferencias);
        }
    }
}
