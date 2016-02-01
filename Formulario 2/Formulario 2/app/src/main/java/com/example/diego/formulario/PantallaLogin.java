package com.example.diego.formulario;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

/**
 * Created by mati on 28/01/16.
 */
public class PantallaLogin extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_registro);

        EditText usuario = (EditText)findViewById(R.id.editText);
        EditText contraseña = (EditText)findViewById(R.id.editText2);

        String auxUsuario = usuario.getText().toString();
        String auxContraseña = contraseña.getText().toString();



    }
}
