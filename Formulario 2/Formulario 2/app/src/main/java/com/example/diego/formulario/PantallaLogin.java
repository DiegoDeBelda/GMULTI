package com.example.diego.formulario;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mati on 28/01/16.
 */
public class PantallaLogin extends AppCompatActivity {
    EditText usuario;
    EditText contraseña;
    Context context;
    Usuarios usuarios;
    SQLiteHelper cliBDh;
    SQLiteDatabase db;

    String auxUsuario;
    String auxContraseña;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registro);
        usuario= (EditText)findViewById(R.id.editText);
        contraseña = (EditText)findViewById(R.id.editText2);
        final TextView mensajeError =(TextView)findViewById(R.id.textView3);



        Button RegistrarUsuario = (Button)findViewById(R.id.button);
        Button IniciarSesion = (Button)findViewById(R.id.button2);

        RegistrarUsuario.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                 auxUsuario = usuario.getText().toString();
                 auxContraseña = contraseña.getText().toString();

                if( auxUsuario!=null && auxContraseña!=null){

                 usuarios = new Usuarios(auxUsuario, auxContraseña);

                cliBDh=new SQLiteHelper(PantallaLogin.this, "DBClientes", null, 1);
                db=cliBDh.getWritableDatabase();
                cliBDh.insertarBDUsuario(db,PantallaLogin.this,usuarios);
                    cliBDh.close();
                    db.close();
                }
            }
        });

        IniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                auxUsuario = usuario.getText().toString();
                auxContraseña = contraseña.getText().toString();

                if( auxUsuario!=null && auxContraseña!=null){
                Usuarios nuevo=new  Usuarios (auxUsuario,auxContraseña);

                    cliBDh=new SQLiteHelper(PantallaLogin.this, "DBClientes", null, 1);
                    db=cliBDh.getReadableDatabase();
                    Usuarios[] array=cliBDh.listarUsuarios(db);

                    for (int i=0; i<array.length; i++){
                        //Toast.makeText(PantallaLogin.this, ""+array[i].getNombre(), Toast.LENGTH_SHORT).show();

                        if(nuevo.getNombre().equals(array[i].getNombre()) && nuevo.getPassword().equals(array[i].getPassword())){
                            Toast.makeText(PantallaLogin.this, "Sesion iniciada como usuario "+nuevo.getNombre()+" Volviendo a la pantalla 1", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            String jhu=array[i].getNombre();
                            Bundle bundle = new Bundle();
                            bundle.putString("Nombre", jhu);
                            intent.putExtras(bundle);

                            startActivity(intent);

                        }


                    }
                    mensajeError.setVisibility(View.VISIBLE);

                    cliBDh.close();
                    db.close();
                }
            }
        });




    }
}
