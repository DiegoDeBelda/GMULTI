package com.example.diego.formulario;

/**
 * Created by mati on 21/01/16.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SQLiteHelper extends SQLiteOpenHelper {
    //Cadena con la sentencia SQL que permite crear la tabla Clientes
    String cadSQL = "CREATE TABLE Destinos if not EXISTS (id INTEGER PRIMARY KEY, zona TEXT,continente TEXT, imagen INTEGER, precio TEXT )";
    String cadSQLUsuarios = "CREATE TABLE Usuarios if not EXISTS (id INTEGER PRIMARY KEY, nombre TEXT, password TEXT)";
    String cadListar = "SELECT * FROM Destinos";
    String cadListarUsuarios = "SELECT * FROM Usuarios";
    //SQLiteDatabase db;

    public SQLiteHelper(Context contexto, String nombre, CursorFactory almacen, int version){
        super(contexto, nombre, almacen, version);
    }

    public void insertarBD( SQLiteDatabase db, Context context, Dest destino ){


        if(db!=null){
        db.execSQL("INSERT INTO Destinos (zona, continente, imagen, precio) " +
                "VALUES ('" + destino.getZona() + "', '"+destino.getContinente()+"', '"+destino.getImagen()+"', '"+destino.getPrecio()+"')");

        db.close();
            Log.d("prueba", "todo bien");

        }
        else{
            Toast.makeText(context, "Error al conectarse", Toast.LENGTH_SHORT).show();

        }

    }

    public void insertarBDUsuario ( SQLiteDatabase db, Context context, Usuarios usuario){


        if(db!=null){
            db.execSQL("INSERT INTO Usuarios (nombre, password)" +
            "VALUES ('" +usuario.getNombre() + "', '"+usuario.getPassword()+"')");

        db.close();
            Log.d("prueba2", "todo Bien");
        }

        else{
            Toast.makeText(context, "Error al conectarse", Toast.LENGTH_SHORT).show();
        }
    }
    public Dest[] listar(SQLiteDatabase db){
        Dest destinoAux;
        Cursor cursor= db.rawQuery(cadListar, null);
        cursor.moveToFirst();
        Dest[] array=new Dest[cursor.getCount()];
        int contador=0;
        do {
            destinoAux=new Dest(cursor.getString(1),cursor.getString(2),cursor.getInt(3),cursor.getString(4));
            array[contador]=destinoAux;
            contador++;
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return array;
    }

    public Usuarios[] listarUsuarios(SQLiteDatabase db){
        Usuarios usuarioAux;
        Cursor cursor=db.rawQuery(cadListarUsuarios, null);
        cursor.moveToFirst();
        Usuarios[] array = new Usuarios[cursor.getCount()];
        int contador = 0;
        do{
            usuarioAux=new Usuarios(cursor.getString(1),cursor.getString(2));
            array[contador]=usuarioAux;
            contador++;
        }while(cursor.moveToNext());
        cursor.close();
        db.close();
        return array;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(cadSQL);
        db.execSQL(cadSQLUsuarios);
    }


    @Override
    public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {

        bd.execSQL("DROP TABLE IF EXISTS Destinos");



        bd.execSQL(cadSQL);
    }
}