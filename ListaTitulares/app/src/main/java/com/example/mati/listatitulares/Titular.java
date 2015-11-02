package com.example.mati.listatitulares;

/**
 * Created by mati on 2/11/15.
 */
public class Titular {
    private String nombre;
    private String apellido;
    Titular obj = new Titular();

    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return  this.apellido;
    }
    public void setNombre(String a){
        this.nombre=a;
    }
    public void setApellido(String b){
        this.nombre=b;
    }

    public Titular(String nombre, String apellido){
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public Titular(){}
    public String ToString(){
        String mensaje="Su Nombre es:"+obj.getNombre()+" y su Apellido es:"+obj.getApellido();
        return mensaje;
    }
}
