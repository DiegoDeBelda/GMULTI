package com.example.mati.basedatosangeles;

/**
 * Created by diego on 14/01/2016.
 */
public class Cliente {
    private String nombre;
    private String telefono;

    Cliente(String a, String b){
        this.nombre = a;
        this.telefono= b;

    }

    public void setNombre(String a){this.nombre=a;}
    public void setTelefono(String b){this.telefono=b;}

    public String getNombre(){return this.nombre;}
    public String getTelefono(){ return this.telefono;}
}