package com.example.diego.formulario;

/**
 * Created by mati on 8/02/16.
 */
public class Usuarios {

    private String nombre;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuarios(String nombre, String password){
        this.nombre=nombre;
        this.password=password;
    }
}

