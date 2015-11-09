package com.example.mati.dbelda;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by mati on 9/11/15.
 */
public class Pantalla2 {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        final TextView Pizza = (TextView) findViewById(R.id.Pizza);
        final TextView Base= (TextView) findViewById(R.id.Base);
        final TextView Extra= (TextView) findViewById(R.id.Extra);
        final TextView Unidades =(TextView) findViewById(R.id.Unidades);
        final TextView Envio = (TextView) findViewById(R.id.Envio);
        final TextView CosteFinal=(TextView) findViewById(R.id.CosteFinal);
        final AnalogClock reloj = (AnalogClock) findviewById(R.id.AnalogClock);

        CheckBox verReloj = (CheckBox) findViewById(R.id.verReloj);


        verReloj.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                reloj.setEnabled(false);
            }
        });




        Bundle miBundleRecoger = getIntent().getExtras();
        Pizza.setText(miBundleRecoger.getString("Nombre"));
        Base.setText(miBundleRecoger.getInt("Precio"));
        Extra.setText(miBundleRecoger.getInt("Extra"));
        Unidades.setText(miBundleRecoger.getInt("Unidades"));
        Envio.setText(miBundleRecoger.getString("Envio"));
        CosteFinal.setText(Base.getText()+Extra.getText());



    }


}
