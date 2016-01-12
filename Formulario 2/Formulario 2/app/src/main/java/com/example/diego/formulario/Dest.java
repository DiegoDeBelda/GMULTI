package com.example.diego.formulario;
class Dest{
private String Zona;
private String Continente;
private String precio;
private int imagen;


public Dest(String zona, String continente, int imagen, String precio ) {
        this.Zona=zona;
        this.Continente=continente;
        this.imagen = imagen;
        this.precio = precio;

        }

public String getZona() {
        return Zona;
        }
public String getContinente(){return Continente;}
        public int getImagen() {
                return imagen;
        }
        public String getPrecio() {
        return precio;
        }



public void setZona(String zona) {
        this.Zona = zona;
}
        public void setContinente(String continente){this.Continente=continente;}
public void setImagen(int imagen) {this.imagen = imagen;}
        public void setPrecio(String precio) {
                this.precio = precio;
        }

        }