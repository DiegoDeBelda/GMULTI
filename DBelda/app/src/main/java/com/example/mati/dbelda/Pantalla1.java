package com.example.mati.dbelda;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Pantalla1 extends AppCompatActivity {

    RadioButton EnLocal = new RadioButton(this);
    RadioButton EnvioDomicilio = new RadioButton(this);

    CheckBox MasGrande = new CheckBox(this);
    CheckBox MasIngredientes = new CheckBox(this);
    CheckBox MasQueso = new CheckBox(this);

    EditText NumeroUnidades = new EditText(this);
    Button Calcular = new Button(this);
    TextView PrecioTotal = new TextView(this);
    Button miButton = new Button(this);




    Pizzas producto1 = new Pizzas("Margarita", "Deliciosa pizza con queso, especias y tomate natural", 10, R.drawable.pizza1);
    Pizzas producto2 = new Pizzas("BBQ", "Maginifica Pizza con carne picada, panceta, abundante queso y deliciosa Salsa BBQ", 15,R.drawable.pizza2);
    Pizzas[] listaDePizzas={producto1, producto2};

    Spinner spinner;
    AdaptadorPizzas adaptador = new AdaptadorPizzas(this);


    int Precio = 0;
    int PrecioExtras=0;
    String cantidad = 0;
    String TipoDeEnvio="En local";
    //para pasar al otro actvity
    String Nombre="";
    int imagenParaPasar;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        initialUISetup();
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner.setAdapter(adaptador);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (listaDePizzas[position]==producto1) {
                    Nombre = producto1.getNombre();
                    Precio=producto1.getPrecio();
                    imagenParaPasar=R.drawable.pizza1;

                }
                if (listaDePizzas[position]==producto2) {
                    Nombre = producto2.getNombre();
                    Precio=producto2.getPrecio();
                    imagenParaPasar=R.drawable.pizza2;
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}


    public void CalcularOnClick(View v) {
        if (MasGrande.isChecked()) {

            Precio += 1;
            PrecioExtras+=1;

        }
        if (MasIngredientes.isChecked()) {

            Precio += 1;
            PrecioExtras+=1;
        }
        if (MasQueso.isChecked()) {

            Precio += 1;
            PrecioExtras+=1;
        }

        if (EnvioDomicilio.isChecked()) {
            int aux = (Precio * 10) / 100;
            Precio += aux;
            TipoDeEnvio="Envio a Domicilio";
        }
        if (NumeroUnidades.getText() == null) {
            Toast.makeText(getApplicationContext(), "Porfavor elija la cantidad ", Toast.LENGTH_SHORT).show();
        }

        PrecioTotal.setText(String.valueOf(Precio));

    }


    public void initialUISetup() {
        //asociacion a la interfaz
        EnLocal = (RadioButton) findViewById(R.id.radioButton1);
        EnvioDomicilio = (RadioButton) findViewById(R.id.radioButton2);

        MasGrande = (CheckBox) findViewById(R.id.checkBox);
        MasIngredientes = (CheckBox) findViewById(R.id.checkBox2);
        MasQueso = (CheckBox) findViewById(R.id.checkBox3);

        miBoton = (Button) findViewById(R.id.botonActivity);

        NumeroUnidades = (EditText) findViewById(R.id.editText);
        Calcular = (Button) findViewById(R.id.button);
        PrecioTotal = (TextView) findViewById(R.id.textView2);
        //escuchador de boton
        Calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CalcularOnClick(v);
            }
        });


        EnvioDomicilio.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CalcularOnClick(buttonView);
            }
        });
        MasGrande.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CalcularOnClick(buttonView);
            }
        });
        MasIngredientes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CalcularOnClick(buttonView);
            }
        });
        MasQueso.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                CalcularOnClick(buttonView);
            }
        });

        miBoton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //intent = objeto cambio actividad
                cantidad=NumeroUnidades.getText();
                Intent miIntent = new Intent(Hola2.this, Pantalla2.class);
                //empaquetar
                Bundle miBundle = new Bundle();

                miBundle.putString("Nombre: ",Nombre);
                miBundle.putInt("Precio: ",Precio);
                miBundle.putInt("Precio Extras :",PrecioExtras);
                miBundle.putString("Envio: ",TipoDeEnvio);
                miBundle.putInt("Foto :",imagenParaPasar);


                miIntent.putExtras(miBundle);

                startActivity(miIntent);
            }
        });
    }











    class AdaptadorPizzas extends ArrayAdapter {
        Activity context;

        AdaptadorPizzas(Activity context) {
            super(context, R.layout.list_item_pizzas, listaDePizzas);
            this.context = context;
        }
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position, convertView, parent);
            return vistaDesplegada;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.list_item_pizzas, null);

            TextView lblNombre = (TextView) item.findViewById(R.id.LblNombre);
            lblNombre.setText(listaDePizzas[position].getNombre());

            TextView lblDescripcion = (TextView) item.findViewById(R.id.LblDescripcion);
            lblDescripcion.setText(listaDePizzas[position].getDescripcion());

            TextView lblPrecio = (TextView) item.findViewById(R.id.LblDescripcion);
            lblPrecio.setText(listaDePizzas[position].getPrecio());
            return (item);

            ImageView lblFoto = (ImageView) item.findViewById(R.id.ImagenPizza);
            lblFoto.setImageResource(listaDePizzas[position].getFotoPizza());

        }
    }


}
