package com.example.diego.formulario;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //objetos utilizables en la primera pantalla
    CheckBox cajaRegalo, conTarjetaDedicada;
    EditText Peso;
    Spinner miSpinner;
    RadioGroup radioGroup;
    Button calcular;

    //variables usadas para pasar datos a la segunda pantalla
    String Zon;
    String Cont;
    int img;
    double pr;
    double precioExtra;
    String Urgencia;
    String preferenciasDelEnvio;
    TextView nombreUsuario=null;
    //array con objetos de tipo Dest para el spinner
    private Dest[] objetosSpinner = new Dest[]{
            new Dest("A","Asia/Oceania",R.drawable.asia, "30"),
            new Dest("B","America/Africa",R.drawable.america,"20"),
            new Dest("C","Europa",R.drawable.europa,"10")
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //este textview indica el usuario activo y se muestra junto al logo de la empresa
        nombreUsuario=(TextView)findViewById(R.id.nombreUsuario);

        //con este if else y este bundle compruebo si hay una sesion iniciada y saco un mensaje.
        Bundle bundle;
        if(( bundle = getIntent().getExtras())==null){
            /*Toast.makeText(MainActivity.this, "No estas inciado como ningun usuario, puede hacerlo desde menu -> Registrar, para acceder a nuevas funciones", Toast.LENGTH_SHORT).show();
            nombreUsuario.setText("Anonimo");*/

            new AlertDialog.Builder(this)
                    .setTitle("Sesion no iniciada")
                    .setMessage("No estas inciado como ningun usuario, puede hacerlo desde menu,Registrar, para acceder a nuevas funciones")
                    .setPositiveButton("iniciar sesion", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            Intent activityIntent2 = new Intent(MainActivity.this, PantallaLogin.class);
                            startActivity(activityIntent2);
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            nombreUsuario.setText("Anonimo");

                            Toast.makeText(MainActivity.this, "Iniciado como Anonimo", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        else{
            bundle = getIntent().getExtras();
            String nombreU = bundle.getString("Nombre");
            nombreUsuario.setText(nombreU);
        }



        cajaRegalo = (CheckBox) findViewById(R.id.cajaRegalo);
        conTarjetaDedicada = (CheckBox) findViewById(R.id.conTarjetaDedicada);

        Peso = (EditText) findViewById(R.id.Peso);


        MiAdaptador adaptador = new MiAdaptador(this);
        miSpinner = (Spinner) findViewById(R.id.spin);
        miSpinner.setAdapter(adaptador);


        radioGroup = (RadioGroup) findViewById(R.id.grupoRadio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (R.id.rb1 == radioGroup.getCheckedRadioButtonId()) {

                    Urgencia = "Tarifa Normal";
                } else {

                    Urgencia = "Tarifa Urgente";
                    precioExtra = precioExtra+(pr*30)/100;

                }
            }
        });

        cajaRegalo.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cajaRegalo.isChecked()) {
                    preferenciasDelEnvio = "con caja regalo";

                } else {
                    preferenciasDelEnvio = "Ninguno";
                    
                }

            }
        });
        conTarjetaDedicada.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (conTarjetaDedicada.isChecked()) {
                    preferenciasDelEnvio = "Envuelto y con una tarjeta dedicatoria";

                } else {
                    preferenciasDelEnvio = "ninguno";

                }
            }
        });


        calcular = (Button) findViewById(R.id.btCal);
        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (Peso.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Inserte el peso del paquete", Toast.LENGTH_SHORT).show();
                } else {
                    int peso = Integer.parseInt(Peso.getText().toString());

                    if(peso<=5){
                        precioExtra = precioExtra + peso;
                    }

                    if(peso>=6 || peso<10){
                        precioExtra= precioExtra + peso*1.5;
                    }

                    if(peso>10){
                        precioExtra = precioExtra + peso*2;
                    }

                    Intent intent = new Intent(MainActivity.this, Pantalla2.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("Zona", Zon);
                    bundle.putString("Continente", Cont);
                    bundle.putDouble("precio", pr);
                    bundle.putDouble("PrecioExtra", precioExtra);
                    bundle.putInt("Peso", peso);
                    bundle.putDouble("PRECIO TOTAL (Precio + precio extra por tipo de envio", pr + precioExtra);
                    bundle.putString("urgencia del envio", Urgencia);
                    bundle.putInt("IMAGEN", img);
                    bundle.putString("Usuario",nombreUsuario.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Opc1:
                Intent activityIntent = new Intent(this, Dibujar.class);
                startActivity(activityIntent);
                return true;
            case R.id.Opc2:
                Toast.makeText(getApplicationContext(), "Diego de Belda Calvo", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Opc3:
                Bundle bundle = new Bundle();
                String usuarioyainiciado = nombreUsuario.getText().toString();
                bundle.putString("Usuario", usuarioyainiciado);
                Intent activityIntent2 = new Intent(this, PantallaLogin.class);
                activityIntent2.putExtras(bundle);
                startActivity(activityIntent2);
                return true;
            case R.id.Opc4:
                nombreUsuario.setText("Anonimo");
                return true;
            case R.id.Opc5:
                Intent activityIntent3 = new Intent(this, PantallaElPais.class);
                startActivity(activityIntent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    class MiAdaptador extends ArrayAdapter<Dest> {

        Activity context;

        MiAdaptador(Activity context) {
            super(context, R.layout.items_spinner, objetosSpinner);
            this.context = context;

        }

        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            return getView(position, convertView, parent);

        }

        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            convertView = inflater.inflate(R.layout.items_spinner, null);

            TextView Zona = (TextView) convertView.findViewById(R.id.zona);
            Zona.setText(objetosSpinner[position].getZona());

            TextView Continente = (TextView) convertView.findViewById(R.id.continente);
            Continente.setText(objetosSpinner[position].getContinente());

            ImageView imagen = (ImageView) convertView.findViewById(R.id.Imagen);
            imagen.setImageResource(objetosSpinner[position].getImagen());

            TextView precio = (TextView) convertView.findViewById(R.id.precio);
            precio.setText(String.valueOf(objetosSpinner[position].getPrecio()));




            Zon = objetosSpinner[position].getZona();
            Cont = objetosSpinner[position].getContinente();
            img = objetosSpinner[position].getImagen();
            pr = Double.parseDouble(objetosSpinner[position].getPrecio());


            return convertView;
        }
    }


}
