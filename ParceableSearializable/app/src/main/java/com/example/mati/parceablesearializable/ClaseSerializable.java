package com.example.mati.parceablesearializable;

/**
 * Created by mati on 11/02/16.
 */

import java.io.Serializable;


public class ClaseSerializable implements Serializable {

    private int id;
    private String nombre;


    public ClaseSerializable(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}