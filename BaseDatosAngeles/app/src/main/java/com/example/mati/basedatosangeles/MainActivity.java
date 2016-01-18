package com.example.mati.basedatosangeles;

import android.app.Activity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    static class ViewHolder{
        TextView nombre;
        TextView telefono;
    }
    Cliente datos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        com.example.mati.basedatosangeles.ClientesSQLiteHelper cliBDh=new
                com.example.mati.basedatosangeles.ClientesSQLiteHelper(this, "DBClientes", null, 1);
        db=cliBDh.getReadableDatabase();
        tratarRegistros();

        final Spinner spi=(Spinner)findViewById(R.id.spin);
        AdaptadorCliente adap=new AdaptadorCliente(this);
        spi.setAdapter(adap);


    }

    public void tratarRegistros(){
        String[] campos=new String[]{"nombre", "telefono"};

        String codSQL="CREATE TABLE IF NOT EXISTS Clientes (codigo INTEGER, nombre TEXT, telefono TEXT)";
        db.execSQL(codSQL);
        for(int i=1;i<=3; i++)
        {
            int codigo=i;
            String nombre="AAA"+i;
            String telefono=i+"XXXXXXX";

            db.execSQL("INSERT INTO Clientes (codigo, nombre, telefono) " +
                    "VALUES (" + codigo + ", '"+nombre+"', '"+telefono+"')");
        }

        Cursor c=db.query("Clientes", campos, null, null, null, null, null);
        datos=new Cliente[c.getCount()];
        int i=0;
        if(c.moveToFirst())
        {
            do{
                String nombreCli=c.getString(0);
                String telefonoCli=c.getString(1);

                datos[i]=new Cliente(nombreCli, telefonoCli);
                i++;
            } while(c.moveToNext());
        }
    }

    class AdaptadorCliente extends ArrayAdapter{
        Activity context;
        @SuppressWarnings("unchecked")
        public AdaptadorCliente(Activity context){
            super(context, R.layout.item_spinner, datos);
            this.context=context;
        }
        public View getDropDownView(int posicion, View convertView, ViewGroup parent){
            return getView(posicion, convertView, parent);
        }
        public View getView(int posicion, View convertView, ViewGroup parent){
            View item=convertView;
            ViewHolder holder;
            if(item==null) {
                LayoutInflater inflater = context.getLayoutInflater();
                item = inflater.inflate(R.layout.item_spinner, null);
                holder=new ViewHolder();
                holder.nombre=(TextView)item.findViewById(R.id.nombre);
                holder.telefono=(TextView)item.findViewById(R.id.telefono);
                item.setTag(holder);
            } else
                holder=(ViewHolder)item.getTag();
            holder.nombre.setText(datos[posicion].getNombre());
            holder.telefono.setText(datos[posicion].getTelefono());
            return item;
        }
    }

}