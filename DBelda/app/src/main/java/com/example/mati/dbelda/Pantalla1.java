package com.example.mati.dbelda;
//imports
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
    //los widgets que vaya a usar en varios metodos los declaro como atributo de clase
    //estos radio button añadiran o no precio extra por el transporte
    RadioButton EnLocal = new RadioButton(this);
    RadioButton EnvioDomicilio = new RadioButton(this);

    //cada uno de estos checkbox's que esten marcados sera 1€ mas al total
    CheckBox MasGrande = new CheckBox(this);
    CheckBox MasIngredientes = new CheckBox(this);
    CheckBox MasQueso = new CheckBox(this);

    //aqui el usuario introduce cuantas unidades quiere
    EditText NumeroUnidades = new EditText(this);
    //boton calcular para saber cuanto hay que cobrar
    Button Calcular = new Button(this);
    //visualizar  cuanto va a costar
    TextView PrecioTotal = new TextView(this);
    //boton para pasar de pantalla
    Button miButton = new Button(this);



    //creo los objetos de tipo pizza con un nombre, descripcion, precio e imagen.
    Pizzas producto1 = new Pizzas("Margarita", "Deliciosa pizza con queso, especias y tomate natural", 10, R.drawable.pizza1);
    Pizzas producto2 = new Pizzas("BBQ", "Maginifica Pizza con carne picada, panceta, abundante queso y deliciosa Salsa BBQ", 15,R.drawable.pizza2);
    //creo un array con los objetos creados de tipo pizza
    Pizzas[] listaDePizzas={producto1, producto2};

    //declaro el spinner y el adaptador de tipo pizza
    Spinner spinner;
    //creo un adapatador de pizzas (esta hecha la clase interna al final del documento)
    AdaptadorPizzas adaptador = new AdaptadorPizzas(this);

    //declaro las variables con las que voy a trabajar
    //precio inicial
    int Precio = 0;
    //precio correspondiente a los extras como por ej +queso
    int PrecioExtras=0;
    //cantidad de pizzas a mandar
    int cantidad = 0;
    //tipo de envio
    String TipoDeEnvio="En local";
    //para pasar al otro actvity (variables que añadiremos con putInt etc
    String Nombre="";
    int imagenParaPasar;




    //metodo on create, cuando se inicie la aplicacion, esto sera lo que primero se haga.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //declaramos el layout que usaremos en esta pantalla
        setContentView(R.layout.activity_pantalla1);
        //llamo al metodo initialSetup, donde configuro la mayoria del programa y asi quitar trabajo al metodo onCreate
        //el metodo initialSetuo se encuentra debajo del metodo CalcularOnClick
        initialUISetup();

        //inicializo el spinner
        spinner = (Spinner) findViewById(R.id.spinner1);
        //le asigno el adapatador que he creado de tipo adapatadorPizzas
        spinner.setAdapter(adaptador);
        //creo el metodo escuchador del spinner el cual estara atento de si seleccionamos un elemento.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            //dentro del escuchador como metodo anonimo creo el onItemSelected
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //con este if else, compruebo que producto ha sido seleccionado y recojo sus
                //atributos en funcionde cual es.
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
            //al crear el metodo anonimo de itemSelected tambian se creara el noItemSelected, en este caso
            //si no selecciona nada no pasa nada.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}

    //este es el metodo asociado al escuchador del boton calcular, comprobara los checkBoxe's
    //y añadira +1 al precio por cada uno, de la misma forma el "contador" precioExtra también aumentara
    //para poder indicar cuanto es lo que hay que pagar de extra.
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
        //si es envio a domicilio añadimos un 10% al precio
        if (EnvioDomicilio.isChecked()) {
            int aux = (Precio * 10) / 100;
            Precio += aux;
            TipoDeEnvio="Envio a Domicilio";
        }
        //si no seleccionamos ninguna cantidad mandamos un TOAST al usuario
        if (NumeroUnidades.getText() == null) {
            Toast.makeText(getApplicationContext(), "Porfavor elija la cantidad ", Toast.LENGTH_SHORT).show();
        }
        //por ultimo rellenamos el textView del precio
        PrecioTotal.setText(String.valueOf(Precio));

    }


    public void initialUISetup() {
        //asociacion a la interfaz
        EnLocal = (RadioButton) findViewById(R.id.radioButton1);
        EnvioDomicilio = (RadioButton) findViewById(R.id.radioButton2);

        MasGrande = (CheckBox) findViewById(R.id.checkBox);
        MasIngredientes = (CheckBox) findViewById(R.id.checkBox2);
        MasQueso = (CheckBox) findViewById(R.id.checkBox3);

        miButton = (Button) findViewById(R.id.botonActivity);

        NumeroUnidades = (EditText) findViewById(R.id.editText);
        Calcular = (Button) findViewById(R.id.button);
        PrecioTotal = (TextView) findViewById(R.id.textView2);
        //escuchador de boton que llama al metodo Calcular on Click
        Calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CalcularOnClick(v);
            }
        });

        //escuchadores de cambio en los checkbox para que vaya cambiando el precio de forma
        //automatica
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
        //escuchador para el boton de cambiar de actividad
        miButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //hacemos que cantidad se rellene con numero de unidades
                cantidad=Integer.parseInt(NumeroUnidades.getText().toString());
                Intent miIntent = new Intent(Pantalla1.this, Pantalla2.class);
                //cargamos el Bundle con todas las variables que necesitamos
                Bundle miBundle = new Bundle();

                miBundle.putString("Nombre",Nombre);
                miBundle.putInt("Precio",Precio);
                miBundle.putInt("Extra",PrecioExtras);
                miBundle.putString("Envio",TipoDeEnvio);
                miBundle.putInt("Foto",imagenParaPasar);
                miBundle.putInt("Unidades",cantidad);


                miIntent.putExtras(miBundle);
                //iniciamos la actividad 2 pasandole el
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
