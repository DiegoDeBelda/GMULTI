package com.example.diego.formulario;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by mati on 25/01/16.
 */
public class pantalla3 extends Activity {
    Dest[] destino ;
    String Zon, Cont;
    double pr;
    int img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla3);

        destino = listarBD(this);

        ListView lista =(ListView) findViewById(R.id.listView);
        ListAdapter adaptador = new ListAdapter(this);
        lista.setAdapter(adaptador);

        lista.setLongClickable(true);
        registerForContextMenu(lista);



    }
    public Dest[] listarBD(Context context){
        SQLiteHelper cliBDh = new SQLiteHelper(context, "DBClientes", null, 1);
        SQLiteDatabase db = cliBDh.getReadableDatabase();
        return cliBDh.listar(db);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lista_m_context, menu);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(pantalla3.this, ""+item.toString(), Toast.LENGTH_SHORT).show();//devuelve e nombre de la opcion
        switch (item.getItemId()) {
            case R.id.delete:

                Toast.makeText(pantalla3.this, "demo borrar", Toast.LENGTH_SHORT).show();
                //las variables de clase almacenan la listView
                SQLiteHelper cliBDh = new SQLiteHelper(this, "DBClientes", null, 1);
                SQLiteDatabase db = cliBDh.getReadableDatabase();
                Dest destino = new Dest(Zon,Cont,img,String.valueOf(pr));
                int id =cliBDh.conseguirId(db, destino);
                Toast.makeText(pantalla3.this, "Esto "+id, Toast.LENGTH_SHORT).show();
                db.close();
                db = cliBDh.getWritableDatabase();
                cliBDh.eliminarPedido(db,id,cliBDh);

                return true;
            case R.id.update:
                Toast.makeText(pantalla3.this, "demo update", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }




    public class ListAdapter extends ArrayAdapter {
        Activity main;
        public ListAdapter (Activity activity){
            super(activity,R.layout.itemlist, destino);
            main=activity;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            convertView = inflater.inflate(R.layout.itemlist, null);

            TextView Zona = (TextView) convertView.findViewById(R.id.zona2);
            Zona.setText(destino[position].getZona());

            TextView Continente = (TextView) convertView.findViewById(R.id.continente2);
            Continente.setText(destino[position].getContinente());

            ImageView imagen = (ImageView) convertView.findViewById(R.id.Imagen2);
            imagen.setImageResource(destino[position].getImagen());

            TextView precio = (TextView) convertView.findViewById(R.id.precio2);
            precio.setText(String.valueOf(destino[position].getPrecio()));




            Zon = destino[position].getZona();
            Cont = destino[position].getContinente();
            img = destino[position].getImagen();
            pr = Double.parseDouble(destino[position].getPrecio());


            return convertView;
        }

    }
}
