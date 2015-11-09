package com.example.mati.dbelda;

import android.media.Image;

/**
 * Created by mati on 9/11/15.
 */
public class Pizzas {

    public String Nombre;
    public String Descripcion;
    public int Precio;
    public int fotoPizza;

    public void setNombre(String a){this.Nombre=a;}
    public void setDescripcion(String a){this.Descripcion=a;}
    public void setPrecio(int a){this.Precio=a;}
    public void setFotoPizza(int a){this.fotoPizza=a;}

    public String getNombre(){return this.Nombre;}
    public String getDescripcion(){return this.Descripcion;}
    public int getPrecio(){return this.Precio;}
    public int getFotoPizza(){return this.fotoPizza;}

    Pizzas(String a, String b, int c, int d){
        Nombre=a;
        Descripcion=b;
        Precio=c;
        fotoPizza=d;
    }
}
